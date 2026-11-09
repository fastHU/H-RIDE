package com.liquidvelo.app.ui.screens

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.os.Build
import android.os.SystemClock
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.MotionEvent
import android.view.WindowManager
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Layers
import androidx.compose.material.icons.rounded.MyLocation
import androidx.compose.material.icons.rounded.Pause
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.liquidvelo.app.data.LocationTrackingHelper
import com.liquidvelo.app.data.RideRepository
import com.liquidvelo.app.model.RideRecord
import com.liquidvelo.app.model.RideTrackPoint
import com.liquidvelo.app.theme.LocalThemePalette
import com.liquidvelo.app.theme.SignalDangerRed
import com.liquidvelo.app.theme.SignalGpsActive
import com.liquidvelo.app.ui.components.ElevationChart
import com.liquidvelo.app.ui.components.GForceRadarView
import com.liquidvelo.app.ui.components.SpeedometerDial
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.CustomZoomButtonsController
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Overlay
import java.util.Locale

@Composable
fun RideActiveScreen(
    trackingHelper: LocationTrackingHelper,
    repository: RideRepository,
    onFinishRide: () -> Unit = {},
    onDiscardRide: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val palette = LocalThemePalette.current
    val rideState by trackingHelper.rideState.collectAsState()
    val gpsStatus by trackingHelper.gpsStatus.collectAsState()
    val gForceData by trackingHelper.sensorHelper.gForceFlow.collectAsState()
    val scrollState = rememberScrollState()

    var showExitDialog by remember { mutableStateOf(false) }

    // Intercept hardware/gesture edge swipe back press so user is shown the exit confirmation dialog
    BackHandler(enabled = true) {
        showExitDialog = true
    }

    // Keep screen on during active cycling
    DisposableEffect(Unit) {
        val window = (context as? Activity)?.window
        try {
            window?.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        } catch (e: Throwable) {
            e.printStackTrace()
        }
        onDispose {
            try {
                window?.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(palette.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .navigationBarsPadding()
                .padding(bottom = 40.dp)
        ) {
            // Top Navigation & Exit Icon
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 52.dp, start = 20.dp, end = 20.dp, bottom = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(46.dp)
                        .clip(CircleShape)
                        .background(palette.surfaceContainerHigh)
                        .clickable { showExitDialog = true },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Close,
                        contentDescription = "退出或暂停",
                        tint = palette.primaryText,
                        modifier = Modifier.size(22.dp)
                    )
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(palette.surfaceContainerHigh)
                        .padding(horizontal = 14.dp, vertical = 8.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(if (rideState.isPaused) SignalDangerRed else SignalGpsActive)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (rideState.isPaused) "已暂停" else "实时记录中",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = palette.primaryText
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // ==========================================
            // TOP CIRCULAR PROGRESS SPEEDOMETER (Opening Downwards, 2-Row Digits)
            // ==========================================
            val liveMaxSpeed = maxOf(
                rideState.maxSpeedKmh,
                rideState.currentSpeedKmh,
                rideState.trackPoints.maxOfOrNull { it.speedKmh } ?: 0f
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                contentAlignment = Alignment.Center
            ) {
                SpeedometerDial(
                    speedKmh = rideState.currentSpeedKmh,
                    maxRecordedSpeed = liveMaxSpeed,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // ==========================================
            // GLANCEABLE METRIC CARDS (Duration, Distance, Altitude)
            // ==========================================
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                val hours = rideState.elapsedSeconds / 3600
                val mins = (rideState.elapsedSeconds % 3600) / 60
                val secs = rideState.elapsedSeconds % 60
                val timeStr = if (hours > 0) {
                    String.format(Locale.US, "%02d:%02d:%02d", hours, mins, secs)
                } else {
                    String.format(Locale.US, "%02d:%02d", mins, secs)
                }
                GlanceCard(
                    label = "骑行耗时",
                    value = timeStr,
                    modifier = Modifier.weight(1f)
                )

                GlanceCard(
                    label = "累计里程",
                    value = String.format(Locale.US, "%.2f km", rideState.distanceKm),
                    modifier = Modifier.weight(1f)
                )

                GlanceCard(
                    label = "当前海拔",
                    value = String.format(Locale.US, "%.1f m", rideState.currentAltitudeM),
                    valueColor = palette.accent,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // ==========================================
            // REAL-TIME G-FORCE CARD (Two Vertical Rows: Real-Time & Peak)
            // ==========================================
            GForceRadarView(
                totalG = gForceData.totalG,
                peakG = maxOf(rideState.maxG, gForceData.peakG),
                modifier = Modifier.padding(horizontal = 20.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // ==========================================
            // REAL-TIME BREADCRUMB TRAJECTORY MAP
            // Supports both Satellite Imagery & Vector Road Map with Live Polyline + Start/Current Markers
            // ==========================================
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "实时轨迹记录",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = palette.primaryText
                )

                Text(
                    text = "${rideState.trackPoints.size} 个轨迹点",
                    fontSize = 12.sp,
                    fontFamily = FontFamily.Monospace,
                    color = palette.secondaryText
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            SafeTrajectoryMinimap(
                trackPoints = rideState.trackPoints,
                currentLat = gpsStatus.latitude,
                currentLng = gpsStatus.longitude,
                hasGpsFix = !gpsStatus.isSearching,
                modifier = Modifier.padding(horizontal = 20.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Real-time Elevation Profile with Interactive Scrubbing
            ElevationChart(
                points = rideState.trackPoints,
                elevationGainM = rideState.elevationGainM,
                currentAltitudeM = rideState.currentAltitudeM,
                modifier = Modifier.padding(horizontal = 20.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))
        }

        // Safety Exit Dialog
        AnimatedVisibility(
            visible = showExitDialog,
            enter = fadeIn() + slideInVertically(initialOffsetY = { it / 2 }),
            exit = fadeOut() + slideOutVertically(targetOffsetY = { it / 2 })
        ) {
            ExitSafetyDialog(
                isPaused = rideState.isPaused,
                onPauseToggle = {
                    if (rideState.isPaused) trackingHelper.resumeRide() else trackingHelper.pauseRide()
                },
                onComplete3SecondHold = {
                    val finalState = trackingHelper.stopRide()
                    val pts = finalState.trackPoints
                    val computedAvgSpeed = if (finalState.elapsedSeconds > 0) {
                        (finalState.distanceKm / (finalState.elapsedSeconds / 3600.0))
                    } else 0.0
                    val computedMaxSpeed = maxOf(
                        pts.filter { it.speedKmh in 0.5f..95f }.maxOfOrNull { it.speedKmh.toDouble() } ?: 0.0,
                        finalState.maxSpeedKmh.toDouble(),
                        finalState.currentSpeedKmh.toDouble().coerceIn(0.0, 95.0)
                    )
                    val computedMaxAlt = pts.maxOfOrNull { it.altitude } ?: finalState.currentAltitudeM
                    val computedMinAlt = pts.minOfOrNull { it.altitude } ?: finalState.currentAltitudeM
                    val computedAvgG = if (pts.isNotEmpty()) {
                        pts.map { it.totalG }.average().toFloat()
                    } else 1.0f

                    val record = RideRecord(
                        title = "骑行记录 ${String.format(Locale.US, "%.2f km", finalState.distanceKm)}",
                        startTime = System.currentTimeMillis() - (finalState.elapsedSeconds * 1000L),
                        endTime = System.currentTimeMillis(),
                        durationSeconds = finalState.elapsedSeconds,
                        distanceKm = finalState.distanceKm,
                        avgSpeedKmh = computedAvgSpeed,
                        maxSpeedKmh = computedMaxSpeed,
                        elevationGainM = finalState.elevationGainM,
                        maxAltitudeM = computedMaxAlt,
                        minAltitudeM = computedMinAlt,
                        maxGForce = finalState.maxG,
                        avgGForce = computedAvgG,
                        points = pts
                    )
                    repository.saveRide(record)
                    showExitDialog = false
                    onFinishRide()
                },
                onDiscardWithoutSaving = {
                    trackingHelper.stopRide()
                    showExitDialog = false
                    onDiscardRide()
                },
                onCancelDialog = {
                    showExitDialog = false
                }
            )
        }
    }
}

/**
 * Dual-Mode Real Map Trajectory View (Supports both Vector Road Map & Satellite Imagery).
 * Renders the walked/cycled path polyline, Green Start Marker, and Orange Current Position Marker
 * on both map layers, without auto-panning while the user interacts with the map.
 */
@SuppressLint("ClickableViewAccessibility")
@Composable
fun SafeTrajectoryMinimap(
    trackPoints: List<RideTrackPoint>,
    currentLat: Double,
    currentLng: Double,
    hasGpsFix: Boolean = true,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val palette = LocalThemePalette.current
    var isSatelliteActive by remember { mutableStateOf(false) }
    var mapViewRef by remember { mutableStateOf<MapView?>(null) }
    var hasCenteredInitialFix by remember { mutableStateOf(false) }

    val latestPoints by rememberUpdatedState(trackPoints)
    val latestLat by rememberUpdatedState(currentLat)
    val latestLng by rememberUpdatedState(currentLng)

    DisposableEffect(context) {
        try {
            Configuration.getInstance().load(context, context.getSharedPreferences("osmdroid", Context.MODE_PRIVATE))
            Configuration.getInstance().userAgentValue = context.packageName
        } catch (e: Throwable) {
            e.printStackTrace()
        }
        onDispose {
            try {
                mapViewRef?.overlays?.clear()
                mapViewRef?.onDetach()
                mapViewRef = null
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }

    // Center once when the first valid GPS coordinate or first track point arrives
    LaunchedEffect(hasGpsFix, trackPoints.size) {
        val mv = mapViewRef ?: return@LaunchedEffect
        if (!hasCenteredInitialFix) {
            if (trackPoints.isNotEmpty()) {
                val p = trackPoints.last()
                mv.controller.setCenter(GeoPoint(p.latitude, p.longitude))
                hasCenteredInitialFix = true
            } else if (hasGpsFix) {
                mv.controller.setCenter(GeoPoint(currentLat, currentLng))
                hasCenteredInitialFix = true
            }
        }
        mv.invalidate()
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(240.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(palette.surface)
    ) {
        AndroidView(
            factory = { ctx ->
                MapView(ctx).apply {
                    setMultiTouchControls(true)
                    isTilesScaledToDpi = true
                    setBuiltInZoomControls(false)
                    zoomController.setVisibility(CustomZoomButtonsController.Visibility.NEVER)
                    setTileSource(if (isSatelliteActive) ArcGisSatelliteSource else TileSourceFactory.MAPNIK)
                    controller.setZoom(17.5)

                    val initLat = if (latestPoints.isNotEmpty()) latestPoints.last().latitude else latestLat
                    val initLng = if (latestPoints.isNotEmpty()) latestPoints.last().longitude else latestLng
                    controller.setCenter(GeoPoint(initLat, initLng))

                    // Prevent parent verticalScroll Column from stealing map pan/pinch gestures
                    setOnTouchListener { v, event ->
                        when (event.actionMasked) {
                            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {
                                v.parent?.requestDisallowInterceptTouchEvent(true)
                            }
                            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                                v.parent?.requestDisallowInterceptTouchEvent(false)
                            }
                        }
                        false
                    }

                    // Custom High-Contrast Trajectory & Start/Current Marker Overlay
                    // Works identically on both Satellite Imagery and Vector Road Map!
                    val trajectoryOverlay = object : Overlay() {
                        private val casingPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
                            color = android.graphics.Color.parseColor("#88000000")
                            style = Paint.Style.STROKE
                            strokeWidth = 14f
                            strokeCap = Paint.Cap.ROUND
                            strokeJoin = Paint.Join.ROUND
                        }
                        private val linePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
                            color = android.graphics.Color.parseColor("#FF7A00")
                            style = Paint.Style.STROKE
                            strokeWidth = 8.5f
                            strokeCap = Paint.Cap.ROUND
                            strokeJoin = Paint.Join.ROUND
                        }
                        private val whiteBorderPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
                            color = android.graphics.Color.WHITE
                            style = Paint.Style.FILL
                        }
                        private val startGreenPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
                            color = android.graphics.Color.parseColor("#34C759")
                            style = Paint.Style.FILL
                        }
                        private val currentOrangePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
                            color = android.graphics.Color.parseColor("#FF7A00")
                            style = Paint.Style.FILL
                        }
                        private val currentHaloPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
                            color = android.graphics.Color.parseColor("#44FF7A00")
                            style = Paint.Style.FILL
                        }

                        override fun draw(canvas: android.graphics.Canvas?, mapView: MapView?, shadow: Boolean) {
                            if (shadow || canvas == null || mapView == null || !mapView.isAttachedToWindow) return
                            try {
                                val proj = mapView.projection ?: return
                                val pts = latestPoints
                                val reusablePt = android.graphics.Point()

                                if (pts.isNotEmpty()) {
                                    // 1. Draw Walked/Cycled Breadcrumb Path
                                    if (pts.size >= 2) {
                                        val androidPath = android.graphics.Path()
                                        pts.forEachIndexed { idx, tp ->
                                            proj.toPixels(GeoPoint(tp.latitude, tp.longitude), reusablePt)
                                            if (idx == 0) {
                                                androidPath.moveTo(reusablePt.x.toFloat(), reusablePt.y.toFloat())
                                            } else {
                                                androidPath.lineTo(reusablePt.x.toFloat(), reusablePt.y.toFloat())
                                            }
                                        }
                                        // Also connect last recorded point to live current GPS position
                                        proj.toPixels(GeoPoint(latestLat, latestLng), reusablePt)
                                        androidPath.lineTo(reusablePt.x.toFloat(), reusablePt.y.toFloat())

                                        canvas.drawPath(androidPath, casingPaint)
                                        canvas.drawPath(androidPath, linePaint)
                                    }

                                    // 2. Draw Start Point Marker (Green Circle with White Border)
                                    val first = pts.first()
                                    proj.toPixels(GeoPoint(first.latitude, first.longitude), reusablePt)
                                    val sx = reusablePt.x.toFloat()
                                    val sy = reusablePt.y.toFloat()
                                    canvas.drawCircle(sx, sy, 13f, whiteBorderPaint)
                                    canvas.drawCircle(sx, sy, 8.5f, startGreenPaint)

                                    // 3. Draw Current Position Marker (Orange Circle with Pulse Halo)
                                    val curGeo = GeoPoint(latestLat, latestLng)
                                    proj.toPixels(curGeo, reusablePt)
                                    val cx = reusablePt.x.toFloat()
                                    val cy = reusablePt.y.toFloat()
                                    canvas.drawCircle(cx, cy, 24f, currentHaloPaint)
                                    canvas.drawCircle(cx, cy, 13f, whiteBorderPaint)
                                    canvas.drawCircle(cx, cy, 8.5f, currentOrangePaint)
                                } else {
                                    // Standby Current Position Marker before movement starts
                                    proj.toPixels(GeoPoint(latestLat, latestLng), reusablePt)
                                    val cx = reusablePt.x.toFloat()
                                    val cy = reusablePt.y.toFloat()
                                    canvas.drawCircle(cx, cy, 24f, currentHaloPaint)
                                    canvas.drawCircle(cx, cy, 13f, whiteBorderPaint)
                                    canvas.drawCircle(cx, cy, 8.5f, currentOrangePaint)
                                }
                            } catch (e: Throwable) {
                                // Guard against projection teardown exceptions
                            }
                        }
                    }

                    overlays.add(trajectoryOverlay)
                    mapViewRef = this
                }
            },
            update = { mv ->
                val expectedSource = if (isSatelliteActive) ArcGisSatelliteSource else TileSourceFactory.MAPNIK
                if (mv.tileProvider.tileSource != expectedSource) {
                    mv.setTileSource(expectedSource)
                }
                mv.setBuiltInZoomControls(false)
                mv.zoomController.setVisibility(CustomZoomButtonsController.Visibility.NEVER)
                mv.invalidate()
            },
            modifier = Modifier.fillMaxSize()
        )

        // Top Right: Material 3 Tonal Pill Mode Toggle (Satellite vs Vector Road Map)
        Row(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(12.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(palette.surfaceContainerHigh)
                .clickable { isSatelliteActive = !isSatelliteActive }
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Rounded.Layers,
                contentDescription = null,
                tint = palette.accent,
                modifier = Modifier.size(15.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = if (isSatelliteActive) "卫星影像" else "道路矢量",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = palette.primaryText
            )
        }

        // Bottom Right: Manual Re-center on Current Position Button
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(12.dp)
                .size(38.dp)
                .clip(CircleShape)
                .background(palette.surfaceContainerHigh)
                .clickable {
                    val targetLat = if (trackPoints.isNotEmpty()) trackPoints.last().latitude else currentLat
                    val targetLng = if (trackPoints.isNotEmpty()) trackPoints.last().longitude else currentLng
                    mapViewRef?.controller?.animateTo(GeoPoint(targetLat, targetLng))
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Rounded.MyLocation,
                contentDescription = "定位当前位置",
                tint = palette.primaryText,
                modifier = Modifier.size(18.dp)
            )
        }

        // Bottom Left Legend
        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(12.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(palette.surfaceContainerHigh)
                .padding(horizontal = 10.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.size(8.dp).clip(CircleShape).background(Color(0xFF34C759)))
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "起点", fontSize = 11.sp, fontWeight = FontWeight.Medium, color = palette.primaryText)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.size(8.dp).clip(CircleShape).background(Color(0xFFFF7A00)))
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "当前与轨迹", fontSize = 11.sp, fontWeight = FontWeight.Medium, color = palette.primaryText)
            }
        }
    }
}

@Composable
private fun GlanceCard(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    valueColor: Color? = null
) {
    val palette = LocalThemePalette.current
    val vColor = valueColor ?: palette.primaryText

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(palette.surface)
            .padding(vertical = 14.dp, horizontal = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = label, fontSize = 11.sp, color = palette.secondaryText)
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = value,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                color = vColor
            )
        }
    }
}

@Composable
private fun ExitSafetyDialog(
    isPaused: Boolean,
    onPauseToggle: () -> Unit,
    onComplete3SecondHold: () -> Unit,
    onDiscardWithoutSaving: () -> Unit,
    onCancelDialog: () -> Unit
) {
    val context = LocalContext.current
    val palette = LocalThemePalette.current
    val vibrator = remember { context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator }
    var holdProgress by remember { mutableFloatStateOf(0f) }
    var isHolding by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    var holdJob by remember { mutableStateOf<Job?>(null) }

    fun vibrateTick() {
        try {
            if (vibrator != null && vibrator.hasVibrator()) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(35, 80))
                } else {
                    vibrator.vibrate(35)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(palette.background.copy(alpha = 0.88f))
            .clickable(onClick = onCancelDialog),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.88f)
                .clickable(enabled = false) {}
                .clip(RoundedCornerShape(28.dp))
                .background(palette.surfaceContainer)
                .border(1.5.dp, palette.borderHighlight, RoundedCornerShape(28.dp))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "骑行控制中心",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = palette.primaryText
            )

            Spacer(modifier = Modifier.height(24.dp))

            // 3-SECOND LONG PRESS TO AUTO-SAVE
            // Unpressed state: solid cream-white button.
            // When held: animated circular progress bar expands and wraps around the button.
            val outerProgressAlpha by animateFloatAsState(
                targetValue = if (isHolding || holdProgress > 0f) 1f else 0f,
                animationSpec = tween(200),
                label = "outer_progress_alpha"
            )

            Box(
                modifier = Modifier
                    .size(136.dp)
                    .pointerInput(Unit) {
                        awaitEachGesture {
                            awaitFirstDown(requireUnconsumed = false)
                            isHolding = true
                            vibrateTick()
                            holdJob = scope.launch {
                                val totalMs = 3000L
                                val startTime = SystemClock.elapsedRealtime()
                                var lastTick = 0L

                                while (isActive) {
                                    val elapsed = SystemClock.elapsedRealtime() - startTime
                                    holdProgress = (elapsed.toFloat() / totalMs).coerceIn(0f, 1f)

                                    if (elapsed - lastTick >= 300L) {
                                        vibrateTick()
                                        lastTick = elapsed
                                    }

                                    if (elapsed >= totalMs) {
                                        vibrateTick()
                                        onComplete3SecondHold()
                                        break
                                    }
                                    delay(16L)
                                }
                            }

                            waitForUpOrCancellation()
                            isHolding = false
                            holdJob?.cancel()
                            holdProgress = 0f
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                // Expanding circular progress bar around the button (revealed only upon press)
                if (outerProgressAlpha > 0.01f) {
                    Canvas(
                        modifier = Modifier
                            .matchParentSize()
                            .graphicsLayer { alpha = outerProgressAlpha }
                    ) {
                        val strokeW = 6.dp.toPx()
                        val pad = strokeW / 2f + 4.dp.toPx()
                        val arcRadius = (size.minDimension / 2f) - pad
                        val arcCenter = Offset(size.width / 2f, size.height / 2f)
                        val arcTopLeft = Offset(arcCenter.x - arcRadius, arcCenter.y - arcRadius)
                        val arcSize = Size(arcRadius * 2f, arcRadius * 2f)

                        drawCircle(
                            color = Color.White.copy(alpha = 0.15f),
                            radius = arcRadius,
                            center = arcCenter,
                            style = Stroke(strokeW)
                        )
                        if (holdProgress > 0f) {
                            drawArc(
                                color = palette.accent,
                                startAngle = -90f,
                                sweepAngle = 360f * holdProgress,
                                useCenter = false,
                                topLeft = arcTopLeft,
                                size = arcSize,
                                style = Stroke(strokeW, cap = StrokeCap.Round)
                            )
                        }
                    }
                }

                // Solid Cream-White Button (Clear contour, dark text for maximum legibility)
                val solidCream = Color(0xFFEBE5DA)
                val buttonDarkText = Color(0xFF0C0E12)

                Box(
                    modifier = Modifier
                        .size(104.dp)
                        .clip(CircleShape)
                        .background(solidCream)
                        .border(1.5.dp, Color(0xFFDCD6CB), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    ) {
                        Text(
                            text = if (isHolding) "${((1f - holdProgress) * 3).toInt() + 1}s" else "长按3秒",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace,
                            color = buttonDarkText,
                            maxLines = 1,
                            softWrap = false
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "完成并保存",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = buttonDarkText.copy(alpha = 0.75f),
                            maxLines = 1,
                            softWrap = false
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            val pauseBtnContentColor = if (isPaused) palette.onAccent else palette.primaryText
            Button(
                onClick = onPauseToggle,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isPaused) palette.accent else palette.surfaceContainerHigh,
                    contentColor = pauseBtnContentColor
                ),
                shape = RoundedCornerShape(25.dp)
            ) {
                Icon(
                    imageVector = if (isPaused) Icons.Rounded.PlayArrow else Icons.Rounded.Pause,
                    contentDescription = null,
                    tint = pauseBtnContentColor,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = if (isPaused) "继续记录" else "暂停记录",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = pauseBtnContentColor
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = onDiscardWithoutSaving,
                    modifier = Modifier
                        .weight(1f)
                        .height(46.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = SignalDangerRed.copy(alpha = 0.18f),
                        contentColor = SignalDangerRed
                    ),
                    shape = RoundedCornerShape(23.dp)
                ) {
                    Text(
                        text = "放弃记录",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = SignalDangerRed
                    )
                }

                Button(
                    onClick = onCancelDialog,
                    modifier = Modifier
                        .weight(1f)
                        .height(46.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = palette.surfaceContainerHigh,
                        contentColor = palette.primaryText
                    ),
                    shape = RoundedCornerShape(23.dp)
                ) {
                    Text(
                        text = "返回码表",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = palette.primaryText
                    )
                }
            }
        }
    }
}
