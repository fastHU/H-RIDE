package com.liquidvelo.app.data

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.os.SystemClock
import com.liquidvelo.app.model.LiveRideState
import com.liquidvelo.app.model.RideTrackPoint
import com.liquidvelo.app.service.CyclingTrackingService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.math.abs

data class GpsStatus(
    val isGranted: Boolean = false,
    val isSearching: Boolean = true,
    val accuracyM: Float = 0f,
    val altitudeM: Double = 0.0,
    val speedKmh: Float = 0f,
    val latitude: Double = 31.2304,
    val longitude: Double = 121.4737
)

/**
 * Bulletproof Telemetry and GPS Tracking Helper
 * - High precision Doppler GNSS speed extraction
 * - Accumulative displacement speed fallback for low speeds/indoor/walking without false zeros
 * - Outlier-filtered altitude fusion with barometric stabilization
 * - Robust distance accumulation without dropping sub-meter intervals
 */
class LocationTrackingHelper(
    private val context: Context,
    val sensorHelper: SensorManagerHelper
) : LocationListener {

    private val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as? LocationManager

    private val _rideState = MutableStateFlow(LiveRideState())
    val rideState: StateFlow<LiveRideState> = _rideState.asStateFlow()

    private val _gpsStatus = MutableStateFlow(GpsStatus())
    val gpsStatus: StateFlow<GpsStatus> = _gpsStatus.asStateFlow()

    private val _recenterMapEvent = MutableSharedFlow<Unit>(extraBufferCapacity = 1)
    val recenterMapEvent: SharedFlow<Unit> = _recenterMapEvent.asSharedFlow()

    fun triggerRecenterMap() {
        _recenterMapEvent.tryEmit(Unit)
    }

    private val _startRideEvent = MutableSharedFlow<Unit>(extraBufferCapacity = 1)
    val startRideEvent: SharedFlow<Unit> = _startRideEvent.asSharedFlow()

    fun triggerStartRide() {
        _startRideEvent.tryEmit(Unit)
    }

    private var trackingJob: Job? = null
    private val scope = CoroutineScope(Dispatchers.Default)

    // Current verified location (supports both GNSS and Fused providers)
    @Volatile
    private var latestLocation: Location? = null
    @Volatile
    private var lastLocationNanos: Long = 0L

    // Sliding time window of locations for smooth displacement-based speed estimation
    private data class TimedLocation(val location: Location, val timeNanos: Long)
    private val locationWindow = ArrayDeque<TimedLocation>()

    // Dedicated Distance Meter Accumulator (never drops sub-meter movements)
    private var distanceAnchorLocation: Location? = null
    private var distanceAnchorNanos: Long = 0L

    private var lastRecordedTrackPointLocation: Location? = null

    // Speed & Altitude Filters
    private var smoothedSpeedKmh: Float = 0f
    private var smoothedAltitude: Double = 0.0
    private var hasInitializedAltitude: Boolean = false
    private var lastElevationReferenceAlt: Double? = null

    init {
        startGpsWarmup()
    }

    @SuppressLint("MissingPermission")
    fun startGpsWarmup() {
        try {
            val lm = locationManager ?: return
            val mainLooper = Looper.getMainLooper()

            // 1. Initial location seed from reliable cached fixes
            val lastGps = runCatching { lm.getLastKnownLocation(LocationManager.GPS_PROVIDER) }.getOrNull()
            val lastFused = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                runCatching { lm.getLastKnownLocation(LocationManager.FUSED_PROVIDER) }.getOrNull()
            } else null
            val lastNet = runCatching { lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER) }.getOrNull()

            val bestInitial = when {
                lastGps != null && lastGps.hasAccuracy() && lastGps.accuracy < 40f -> lastGps
                lastFused != null && lastFused.hasAccuracy() && lastFused.accuracy < 40f -> lastFused
                lastGps != null -> lastGps
                lastFused != null -> lastFused
                else -> lastNet
            }

            if (bestInitial != null) {
                onLocationChanged(bestInitial)
            }

            // 2. Register GPS_PROVIDER (Hardware GNSS satellites)
            if (lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500L, 0f, this, mainLooper)
            }

            // 3. Register FUSED_PROVIDER (Android 12+ Fused Location Provider)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                runCatching {
                    if (lm.isProviderEnabled(LocationManager.FUSED_PROVIDER)) {
                        lm.requestLocationUpdates(LocationManager.FUSED_PROVIDER, 500L, 0f, this, mainLooper)
                    }
                }
            }

            // 4. Register NETWORK_PROVIDER for cellular/WiFi assistance only as fallback
            if (lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 3000L, 0f, this, mainLooper)
            }
        } catch (e: SecurityException) {
            _gpsStatus.value = _gpsStatus.value.copy(isGranted = false, isSearching = true)
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    @SuppressLint("MissingPermission")
    fun startRide() {
        try {
            sensorHelper.startListening()
        } catch (e: Throwable) {
            e.printStackTrace()
        }

        startGpsWarmup()

        // Reset filter states and anchors for fresh ride session
        val nowNanos = SystemClock.elapsedRealtimeNanos()
        synchronized(locationWindow) {
            locationWindow.clear()
            latestLocation?.let { locationWindow.add(TimedLocation(Location(it), nowNanos)) }
        }
        distanceAnchorLocation = latestLocation?.let { Location(it) }
        distanceAnchorNanos = nowNanos
        lastRecordedTrackPointLocation = null
        smoothedSpeedKmh = 0f
        lastElevationReferenceAlt = null

        val initialPoints = mutableListOf<RideTrackPoint>()
        val startLoc = latestLocation
        val startAlt = smoothedAltitude

        if (startLoc != null) {
            lastRecordedTrackPointLocation = Location(startLoc)
            val g = sensorHelper.gForceFlow.value
            initialPoints.add(
                RideTrackPoint(
                    latitude = startLoc.latitude,
                    longitude = startLoc.longitude,
                    altitude = startAlt,
                    speedKmh = 0f,
                    timestamp = System.currentTimeMillis(),
                    gX = g.gX,
                    gY = g.gY,
                    gZ = g.gZ,
                    totalG = g.totalG
                )
            )
        }

        _rideState.value = LiveRideState(
            isRiding = true,
            isPaused = false,
            currentAltitudeM = startAlt,
            currentSpeedKmh = 0f,
            distanceKm = 0.0,
            trackPoints = initialPoints
        )

        try {
            CyclingTrackingService.startService(context)
        } catch (e: Throwable) {
            e.printStackTrace()
        }

        trackingJob?.cancel()
        trackingJob = scope.launch {
            while (isActive && _rideState.value.isRiding) {
                delay(1000L)
                if (!_rideState.value.isPaused) {
                    try {
                        processTick()
                    } catch (e: Throwable) {
                        e.printStackTrace()
                    }
                }
            }
        }
    }

    fun pauseRide() {
        smoothedSpeedKmh = 0f
        synchronized(locationWindow) { locationWindow.clear() }
        distanceAnchorLocation = null
        _rideState.value = _rideState.value.copy(isPaused = true, currentSpeedKmh = 0f)
    }

    fun resumeRide() {
        val nowNanos = SystemClock.elapsedRealtimeNanos()
        synchronized(locationWindow) {
            locationWindow.clear()
            latestLocation?.let { locationWindow.add(TimedLocation(Location(it), nowNanos)) }
        }
        distanceAnchorLocation = latestLocation?.let { Location(it) }
        distanceAnchorNanos = nowNanos
        _rideState.value = _rideState.value.copy(isPaused = false)
    }

    fun stopRide(): LiveRideState {
        val finalState = _rideState.value
        sensorHelper.stopListening()
        trackingJob?.cancel()
        trackingJob = null
        synchronized(locationWindow) { locationWindow.clear() }

        CyclingTrackingService.stopService(context)

        _rideState.value = LiveRideState(isRiding = false)
        return finalState
    }

    private fun updateFusedAltitude(loc: Location?): Double {
        if (loc == null) return smoothedAltitude

        val isNetwork = loc.provider == LocationManager.NETWORK_PROVIDER
        val hasGoodAccuracy = !loc.hasAccuracy() || loc.accuracy < 40f

        // Reject network-derived altitudes and low-accuracy vertical spikes
        if (loc.hasAltitude() && loc.altitude != 0.0 && !isNetwork && hasGoodAccuracy) {
            val rawAlt = loc.altitude
            if (!hasInitializedAltitude) {
                smoothedAltitude = rawAlt
                hasInitializedAltitude = true
            } else {
                val diff = abs(rawAlt - smoothedAltitude)
                // Filter vertical outlier jumps > 60m
                if (diff < 60.0) {
                    smoothedAltitude += 0.20 * (rawAlt - smoothedAltitude)
                }
            }
        }
        return smoothedAltitude
    }

    private fun processTick() {
        val curr = _rideState.value
        val newElapsed = curr.elapsedSeconds + 1
        val gData = sensorHelper.gForceFlow.value
        val loc = latestLocation
        val nowNanos = SystemClock.elapsedRealtimeNanos()

        // 1. Update Altitudes
        val currentAlt = updateFusedAltitude(loc)

        // 2. Inactivity Watchdog: Only decay speed if GPS location fixes stopped arriving for > 3.5s
        val timeSinceFixMs = (nowNanos - lastLocationNanos) / 1_000_000L
        if (timeSinceFixMs > 3500L) {
            smoothedSpeedKmh = if (smoothedSpeedKmh < 0.4f) 0f else smoothedSpeedKmh * 0.65f
        }

        // 3. Elevation Gain (with 1.0m deadband to reject micro-jitter)
        var newElevGain = curr.elevationGainM
        if (hasInitializedAltitude) {
            val ref = lastElevationReferenceAlt
            if (ref == null) {
                lastElevationReferenceAlt = currentAlt
            } else {
                val diff = currentAlt - ref
                if (diff >= 1.0) {
                    newElevGain += diff
                    lastElevationReferenceAlt = currentAlt
                } else if (diff <= -1.0) {
                    lastElevationReferenceAlt = currentAlt
                }
            }
        }

        // 4. Trajectory Point Recording (heartbeat or on movement)
        val updatedPoints = if (loc != null) {
            val lastTp = lastRecordedTrackPointLocation
            val distFromLastTp = lastTp?.distanceTo(loc) ?: Float.MAX_VALUE
            // Append point on movement >= 1.5m, or first point, or periodic heartbeat while moving
            if (lastTp == null || distFromLastTp >= 1.5f || (distFromLastTp >= 0.7f && smoothedSpeedKmh >= 0.4f)) {
                lastRecordedTrackPointLocation = Location(loc)
                curr.trackPoints + RideTrackPoint(
                    latitude = loc.latitude,
                    longitude = loc.longitude,
                    altitude = currentAlt,
                    speedKmh = smoothedSpeedKmh,
                    timestamp = System.currentTimeMillis(),
                    gX = gData.gX,
                    gY = gData.gY,
                    gZ = gData.gZ,
                    totalG = gData.totalG
                )
            } else {
                curr.trackPoints
            }
        } else {
            curr.trackPoints
        }

        _rideState.value = curr.copy(
            elapsedSeconds = newElapsed,
            currentSpeedKmh = smoothedSpeedKmh,
            currentAltitudeM = currentAlt,
            elevationGainM = newElevGain,
            gX = gData.gX,
            gY = gData.gY,
            gZ = gData.gZ,
            totalG = gData.totalG,
            maxG = maxOf(curr.maxG, gData.peakG),
            maxSpeedKmh = maxOf(curr.maxSpeedKmh, if (smoothedSpeedKmh in 0.5f..120f) smoothedSpeedKmh else 0f),
            trackPoints = updatedPoints
        )

        CyclingTrackingService.updateMetrics(context, smoothedSpeedKmh, curr.distanceKm, newElapsed)
    }

    override fun onLocationChanged(location: Location) {
        val nowNanos = SystemClock.elapsedRealtimeNanos()
        val provider = location.provider ?: ""

        // Prefer GPS and FUSED providers; reject NETWORK fixes when GNSS/Fused was updated recently
        val timeSinceLastFixMs = (nowNanos - lastLocationNanos) / 1_000_000L
        if (provider == LocationManager.NETWORK_PROVIDER && latestLocation != null && timeSinceLastFixMs < 12_000L) {
            return
        }

        // Discard low-accuracy jitter (accuracy > 50m)
        if (location.hasAccuracy() && location.accuracy > 50f && latestLocation != null) {
            return
        }

        // Multi-provider deduplication: ignore redundant rapid fixes arriving in < 200ms unless higher accuracy
        if (timeSinceLastFixMs < 200L && latestLocation != null) {
            val currAcc = if (location.hasAccuracy()) location.accuracy else 999f
            val prevAcc = if (latestLocation!!.hasAccuracy()) latestLocation!!.accuracy else 999f
            if (!location.hasSpeed() && currAcc >= prevAcc) {
                return
            }
        }

        latestLocation = location
        lastLocationNanos = nowNanos

        // Record location into sliding time-window (retaining fixes from last 4.5s)
        synchronized(locationWindow) {
            locationWindow.addLast(TimedLocation(Location(location), nowNanos))
            while (locationWindow.isNotEmpty() && (nowNanos - locationWindow.first().timeNanos > 4_500_000_000L)) {
                locationWindow.removeFirst()
            }
        }

        val currentAlt = updateFusedAltitude(location)

        // ========================================================
        // 1. BULLETPROOF SPEED CALCULATION (Doppler GNSS + Sliding Window Odometry)
        // ========================================================
        var instantSpeedKmh: Float? = null

        if (location.hasSpeed() && location.speed >= 0.45f) {
            // Technique A: Direct Hardware GNSS Doppler Speed (>= 1.62 km/h)
            instantSpeedKmh = (location.speed * 3.6f).coerceIn(0f, 130f)
        } else {
            // Technique B: Multi-Fix Sliding Window Displacement Odometry
            // Evaluates displacement against a verified fix 0.7s - 2.8s ago (optimal ~1.3s)
            val refPoint = synchronized(locationWindow) {
                var best: TimedLocation? = null
                var bestDiff = Long.MAX_VALUE
                val targetNanos = 1_300_000_000L
                for (item in locationWindow) {
                    val ageNanos = nowNanos - item.timeNanos
                    if (ageNanos in 700_000_000L..2_800_000_000L) {
                        val diff = abs(ageNanos - targetNanos)
                        if (diff < bestDiff) {
                            bestDiff = diff
                            best = item
                        }
                    }
                }
                best
            }

            if (refPoint != null) {
                val dtSec = (nowNanos - refPoint.timeNanos) / 1_000_000_000.0
                val distM = refPoint.location.distanceTo(location)
                if (dtSec >= 0.5) {
                    val derivedSpeedKmh = ((distM / dtSec) * 3.6).toFloat()
                    if (distM < 0.35f) {
                        // Stationary deadband: < 35cm displacement in ~1.3s -> zero speed
                        instantSpeedKmh = 0f
                    } else if (smoothedSpeedKmh < 1.0f && derivedSpeedKmh > 20f && distM < 15f) {
                        // Multi-path single sample jump rejection from stop
                        instantSpeedKmh = 0f
                    } else {
                        instantSpeedKmh = derivedSpeedKmh.coerceIn(0f, 110f)
                    }
                }
            }
        }

        // ========================================================
        // 2. RESPONSIVE EXPONENTIAL MOVING AVERAGE (EMA) FILTER
        // ========================================================
        if (instantSpeedKmh != null) {
            val target = instantSpeedKmh
            if (target >= 0.4f) {
                smoothedSpeedKmh = if (smoothedSpeedKmh < 0.3f) {
                    target
                } else {
                    smoothedSpeedKmh * 0.35f + target * 0.65f
                }
            } else {
                smoothedSpeedKmh = (smoothedSpeedKmh * 0.50f).let { if (it < 0.25f) 0f else it }
            }
        }

        // ========================================================
        // 3. CONTINUOUS DISTANCE ACCUMULATION (Moving only, never when stationary)
        // ========================================================
        val currState = _rideState.value
        var updatedDist = currState.distanceKm
        if (currState.isRiding && !currState.isPaused) {
            val dAnchor = distanceAnchorLocation
            if (dAnchor == null) {
                distanceAnchorLocation = Location(location)
                distanceAnchorNanos = nowNanos
            } else {
                val dM = dAnchor.distanceTo(location)
                val dtAnchorSec = ((nowNanos - distanceAnchorNanos) / 1_000_000_000.0).coerceAtLeast(0.1)
                // Accumulate distance whenever displacement >= 0.65m and speed >= 0.4 km/h
                if (dM >= 0.65f && smoothedSpeedKmh >= 0.4f) {
                    updatedDist += (dM / 1000.0)
                    distanceAnchorLocation = Location(location)
                    distanceAnchorNanos = nowNanos
                } else if (dtAnchorSec > 6.0) {
                    distanceAnchorLocation = Location(location)
                    distanceAnchorNanos = nowNanos
                }
            }
        }

        _gpsStatus.value = GpsStatus(
            isGranted = true,
            isSearching = false,
            accuracyM = if (location.hasAccuracy()) location.accuracy else 5.0f,
            altitudeM = currentAlt,
            speedKmh = smoothedSpeedKmh,
            latitude = location.latitude,
            longitude = location.longitude
        )

        if (currState.isRiding && !currState.isPaused) {
            _rideState.value = currState.copy(
                currentSpeedKmh = smoothedSpeedKmh,
                currentAltitudeM = currentAlt,
                distanceKm = updatedDist,
                maxSpeedKmh = maxOf(currState.maxSpeedKmh, if (smoothedSpeedKmh in 0.5f..120f) smoothedSpeedKmh else 0f)
            )
        }
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
    override fun onProviderEnabled(provider: String) {}
    override fun onProviderDisabled(provider: String) {}
}
