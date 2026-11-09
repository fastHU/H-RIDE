package com.liquidvelo.app.ui.screens

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Paint
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.DirectionsBike
import androidx.compose.material.icons.rounded.Layers
import androidx.compose.material.icons.rounded.MyLocation
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.liquidvelo.app.data.LocationTrackingHelper
import com.liquidvelo.app.theme.LocalThemePalette
import com.liquidvelo.app.theme.SignalGpsActive
import com.liquidvelo.app.theme.SignalWarningAmber
import com.liquidvelo.app.ui.components.CountdownOverlay
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.util.MapTileIndex
import org.osmdroid.views.CustomZoomButtonsController
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Overlay
import java.util.Locale

val ArcGisSatelliteSource = object : OnlineTileSourceBase(
    "ArcGIS_Satellite",
    0,
    19,
    256,
    ".jpg",
    arrayOf("https://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/")
) {
    override fun getTileURLString(pMapTileIndex: Long): String {
        val zoom = MapTileIndex.getZoom(pMapTileIndex)
        val x = MapTileIndex.getX(pMapTileIndex)
        val y = MapTileIndex.getY(pMapTileIndex)
        return "${baseUrl}${zoom}/${y}/${x}${mImageFilenameEnding}"
    }
}

@Composable
fun MapScreen(
    trackingHelper: LocationTrackingHelper,
    onStartRideConfirmed: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val palette = LocalThemePalette.current
    val gpsStatus by trackingHelper.gpsStatus.collectAsState()

    var isSatelliteMode by remember { mutableStateOf(true) }
    var showCountdown by remember { mutableStateOf(false) }
    var mapViewInstance by remember { mutableStateOf<MapView?>(null) }
    var hasCenteredUserLocation by remember { mutableStateOf(false) }

    // Listen to recenter event triggered by the Dock bar's location button
    LaunchedEffect(Unit) {
        trackingHelper.recenterMapEvent.collect {
            mapViewInstance?.controller?.animateTo(GeoPoint(gpsStatus.latitude, gpsStatus.longitude))
        }
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { results ->
        val fineGranted = results[Manifest.permission.ACCESS_FINE_LOCATION] == true
        if (fineGranted) {
            trackingHelper.startGpsWarmup()
            showCountdown = true
        }
    }

    // Triggered when user taps the Start Ride button on the Dock bar
    LaunchedEffect(Unit) {
        trackingHelper.startRideEvent.collect {
            val hasFine = ContextCompat.checkSelfPermission(
                context, Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
            if (!hasFine) {
                permissionLauncher.launch(
                    arrayOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                )
            } else {
                trackingHelper.startGpsWarmup()
                showCountdown = true
            }
        }
    }

    DisposableEffect(context) {
        try {
            Configuration.getInstance().load(context, context.getSharedPreferences("osmdroid", Context.MODE_PRIVATE))
            Configuration.getInstance().userAgentValue = context.packageName
        } catch (e: Throwable) {
            e.printStackTrace()
        }
        onDispose {
            try {
                mapViewInstance?.overlays?.clear()
                mapViewInstance?.onDetach()
                mapViewInstance = null
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }

    Box(modifier = modifier.fillMaxSize()) {
        // Native Map with Enchanced High-Visibility User Location Marker Puck
        AndroidView(
            factory = { ctx ->
                MapView(ctx).apply {
                    setMultiTouchControls(true)
                    isTilesScaledToDpi = true
                    setBuiltInZoomControls(false)
                    zoomController.setVisibility(CustomZoomButtonsController.Visibility.NEVER)
                    setTileSource(if (isSatelliteMode) ArcGisSatelliteSource else TileSourceFactory.MAPNIK)
                    controller.setZoom(16.5)
                    controller.setCenter(GeoPoint(gpsStatus.latitude, gpsStatus.longitude))

                    // Prominent, Large High-Contrast User Location Puck Overlay
                    val userLocationOverlay = object : Overlay() {
                        private val haloPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
                            color = android.graphics.Color.parseColor("#350A84FF")
                            style = Paint.Style.FILL
                        }
                        private val midHaloPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
                            color = android.graphics.Color.parseColor("#550A84FF")
                            style = Paint.Style.FILL
                        }
                        private val whiteBorderPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
                            color = android.graphics.Color.WHITE
                            style = Paint.Style.FILL
                        }
                        private val blueCorePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
                            color = android.graphics.Color.parseColor("#0A84FF")
                            style = Paint.Style.FILL
                        }
                        private val centerPipPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
                            color = android.graphics.Color.WHITE
                            style = Paint.Style.FILL
                        }

                        override fun draw(canvas: android.graphics.Canvas?, mapView: MapView?, shadow: Boolean) {
                            try {
                                if (shadow || canvas == null || mapView == null || !mapView.isAttachedToWindow) return
                                val projection = mapView.projection ?: return
                                val userGeo = GeoPoint(gpsStatus.latitude, gpsStatus.longitude)
                                val pt = android.graphics.Point()
                                projection.toPixels(userGeo, pt)

                                val cx = pt.x.toFloat()
                                val cy = pt.y.toFloat()

                                // Noticeably larger, prominent navigation puck
                                canvas.drawCircle(cx, cy, 48f, haloPaint)
                                canvas.drawCircle(cx, cy, 30f, midHaloPaint)
                                canvas.drawCircle(cx, cy, 20f, whiteBorderPaint)
                                canvas.drawCircle(cx, cy, 14f, blueCorePaint)
                                canvas.drawCircle(cx, cy, 5f, centerPipPaint)
                            } catch (e: Throwable) {
                                // Guard against draw-time projection teardown
                            }
                        }
                    }
                    overlays.add(userLocationOverlay)
                    mapViewInstance = this
                }
            },
            update = { mv ->
                mv.setTileSource(if (isSatelliteMode) ArcGisSatelliteSource else TileSourceFactory.MAPNIK)
                mv.setBuiltInZoomControls(false)
                mv.zoomController.setVisibility(CustomZoomButtonsController.Visibility.NEVER)

                if (!hasCenteredUserLocation && !gpsStatus.isSearching && gpsStatus.accuracyM > 0f) {
                    mv.controller.animateTo(GeoPoint(gpsStatus.latitude, gpsStatus.longitude))
                    hasCenteredUserLocation = true
                }
                mv.invalidate()
            },
            modifier = Modifier.fillMaxSize()
        )

        // Top Subtle Gradient
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(palette.background.copy(alpha = 0.85f), Color.Transparent)
                    )
                )
        )

        // Top Status Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 52.dp, start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Real-time GPS Satellite Status Pill
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(18.dp))
                    .background(palette.surface)
                    .padding(horizontal = 14.dp, vertical = 8.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    val dotColor = if (!gpsStatus.isSearching && gpsStatus.accuracyM > 0f) SignalGpsActive else SignalWarningAmber
                    Box(
                        modifier = Modifier
                            .size(7.5.dp)
                            .clip(CircleShape)
                            .background(dotColor)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    val statusText = if (!gpsStatus.isSearching && gpsStatus.accuracyM > 0f) {
                        "GPS 定位正常 · ±${gpsStatus.accuracyM.toInt()}m"
                    } else {
                        "正在搜寻 GPS 卫星..."
                    }
                    Text(
                        text = statusText,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = palette.primaryText
                    )
                }
            }

            // Map Layer Toggle
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(18.dp))
                    .background(palette.surface)
                    .clickable { isSatelliteMode = !isSatelliteMode }
                    .padding(horizontal = 14.dp, vertical = 8.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Rounded.Layers,
                        contentDescription = "图层",
                        tint = palette.accent,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (isSatelliteMode) "卫星影像" else "道路矢量",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = palette.primaryText
                    )
                }
            }
        }

        // 3-Second Precision Countdown Overlay
        AnimatedVisibility(
            visible = showCountdown,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            CountdownOverlay(
                onCountdownFinished = {
                    showCountdown = false
                    try {
                        onStartRideConfirmed()
                    } catch (e: Throwable) {
                        e.printStackTrace()
                    }
                },
                onCancel = {
                    showCountdown = false
                }
            )
        }
    }
}
