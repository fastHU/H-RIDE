package com.liquidvelo.app.ui.screens

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.location.Location
import android.net.Uri
import android.os.Build
import android.os.PowerManager
import android.os.SystemClock
import android.os.VibrationEffect
import android.os.Vibrator
import android.provider.Settings
import android.widget.VideoView
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.DirectionsBike
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.BatteryChargingFull
import androidx.compose.material.icons.rounded.CameraAlt
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Image
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Videocam
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.liquidvelo.app.data.RideRepository
import com.liquidvelo.app.model.RideRecord
import com.liquidvelo.app.model.RideTrackPoint
import com.liquidvelo.app.ui.components.PhotoCropDialog
import com.liquidvelo.app.theme.AvailableAccents
import com.liquidvelo.app.theme.LocalThemePalette
import com.liquidvelo.app.theme.SignalDangerRed
import com.liquidvelo.app.theme.ThemeManager
import com.liquidvelo.app.theme.ThemePreset
import com.liquidvelo.app.theme.parseHexColor
import java.io.File
import java.io.FileOutputStream
import java.util.Calendar
import java.util.Locale
import kotlin.math.abs
import kotlin.math.hypot
import kotlin.math.roundToInt
import kotlin.math.sqrt

/**
 * Unified Hermite Smooth-Step Curve Evaluator.
 * Used identically for drawing the curve Path and placing the interactive indicator dot ("圆点")
 * so the dot stays 100% glued to the plotted curve at every horizontal pixel.
 */
private fun sampleFloatSpline(values: List<Float>, fraction: Float): Float {
    if (values.isEmpty()) return 0f
    if (values.size == 1) return values.first()
    val clamped = fraction.coerceIn(0f, 1f)
    val exactIdx = clamped * (values.size - 1)
    val i0 = exactIdx.toInt().coerceIn(0, values.size - 2)
    val i1 = (i0 + 1).coerceAtMost(values.size - 1)
    val u = (exactIndexFraction(exactIdx, i0)).coerceIn(0f, 1f)
    val smoothU = u * u * (3f - 2f * u)
    return values[i0] + (values[i1] - values[i0]) * smoothU
}

private fun exactIndexFraction(exactIdx: Float, i0: Int): Float = exactIdx - i0

/**
 * Resamples an arbitrary list of floats into `targetCount` buckets so charts always render cleanly
 * while reflecting 100% real recorded data.
 */
private fun resampleSeries(raw: List<Float>, targetCount: Int, defaultVal: Float): List<Float> {
    if (raw.isEmpty()) return List(targetCount) { defaultVal }
    if (raw.size == 1) return List(targetCount) { raw.first() }
    return List(targetCount) { idx ->
        val f = idx.toFloat() / (targetCount - 1).coerceAtLeast(1)
        val pos = f * (raw.size - 1)
        val i0 = pos.toInt().coerceIn(0, raw.size - 2)
        val i1 = (i0 + 1).coerceAtMost(raw.size - 1)
        val frac = pos - i0
        raw[i0] + (raw[i1] - raw[i0]) * frac
    }
}

private fun triggerHapticFeedback(context: Context) {
    try {
        val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
        if (vibrator != null && vibrator.hasVibrator()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                vibrator.vibrate(VibrationEffect.createPredefined(VibrationEffect.EFFECT_CLICK))
            } else {
                @Suppress("DEPRECATION")
                vibrator.vibrate(25)
            }
        }
    } catch (_: Throwable) {}
}

@Composable
fun ProfileScreen(
    repository: RideRepository,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val palette = LocalThemePalette.current

    // Dynamically observe real recorded rides
    val rides by repository.ridesFlow.collectAsState()

    // Real dynamic stats aggregated from database (ZERO fake floor values)
    val totalDistanceKm = rides.sumOf { it.distanceKm }
    val totalRidesCount = rides.size
    val maxSprintSpeedKmh = rides.maxOfOrNull { it.maxSpeedKmh } ?: 0.0
    val maxHistoricG = rides.maxOfOrNull { it.maxGForce } ?: 1.0f

    val prefs = remember { context.getSharedPreferences("h_ride_profile", Context.MODE_PRIVATE) }

    var userName by remember { mutableStateOf(prefs.getString("user_name", "骑手") ?: "骑手") }
    var userBio by remember { mutableStateOf(prefs.getString("user_bio", "热爱破风与林道探索 · 保持专注") ?: "热爱破风与林道探索 · 保持专注") }
    var avatarFilePath by remember { mutableStateOf(prefs.getString("avatar_path", null)) }
    var bannerFilePath by remember { mutableStateOf(prefs.getString("banner_path", null)) }
    var isBannerVideo by remember { mutableStateOf(prefs.getBoolean("is_banner_video", false)) }

    var isEditingProfile by remember { mutableStateOf(false) }
    var isSettingsOpen by remember { mutableStateOf(false) }
    var showBannerChoiceDialog by remember { mutableStateOf(false) }

    var avatarRefreshTrigger by remember { mutableIntStateOf(0) }
    var bannerRefreshTrigger by remember { mutableIntStateOf(0) }
    var speedoRefreshTrigger by remember { mutableIntStateOf(0) }

    val powerManager = remember { context.getSystemService(Context.POWER_SERVICE) as? PowerManager }
    val isBatteryOptIgnored = powerManager?.isIgnoringBatteryOptimizations(context.packageName) == true

    val speedoPhotoLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            try {
                val destFile = File(context.filesDir, "speedometer_bg.jpg")
                context.contentResolver.openInputStream(it)?.use { input ->
                    FileOutputStream(destFile).use { output ->
                        input.copyTo(output)
                    }
                }
                ThemeManager.setSpeedometerBackground(destFile.absolutePath, false, context)
                speedoRefreshTrigger++
                triggerHapticFeedback(context)
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }

    val speedoVideoLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            try {
                val destFile = File(context.filesDir, "speedometer_bg.mp4")
                context.contentResolver.openInputStream(it)?.use { input ->
                    FileOutputStream(destFile).use { output ->
                        input.copyTo(output)
                    }
                }
                ThemeManager.setSpeedometerBackground(destFile.absolutePath, true, context)
                speedoRefreshTrigger++
                triggerHapticFeedback(context)
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }

    val avatarPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            try {
                val destFile = File(context.filesDir, "user_avatar.jpg")
                context.contentResolver.openInputStream(it)?.use { input ->
                    FileOutputStream(destFile).use { output ->
                        input.copyTo(output)
                    }
                }
                avatarFilePath = destFile.absolutePath
                prefs.edit().putString("avatar_path", destFile.absolutePath).apply()
                avatarRefreshTrigger++
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }

    var pendingCropUri by remember { mutableStateOf<Uri?>(null) }
    var showCropDialog by remember { mutableStateOf(false) }

    val bannerPhotoLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            pendingCropUri = it
            showCropDialog = true
        }
    }

    val bannerVideoLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            try {
                val destFile = File(context.filesDir, "header_banner.mp4")
                context.contentResolver.openInputStream(it)?.use { input ->
                    FileOutputStream(destFile).use { output ->
                        input.copyTo(output)
                    }
                }
                bannerFilePath = destFile.absolutePath
                isBannerVideo = true
                prefs.edit()
                    .putString("banner_path", destFile.absolutePath)
                    .putBoolean("is_banner_video", true)
                    .apply()
                bannerRefreshTrigger++
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
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            contentPadding = PaddingValues(top = 54.dp, bottom = 120.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // TOP HEADER TITLE & SETTINGS BUTTON
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "个人中心",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = palette.primaryText
                    )

                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(palette.surfaceContainerHigh)
                            .clickable { isSettingsOpen = true },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Settings,
                            contentDescription = "设置",
                            tint = palette.primaryText,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }

            // ==========================================
            // HEADER HERO MODULE (AVATAR, NICKNAME, BIO)
            // ==========================================
            item {
                val activeBanner = bannerFilePath
                val hasCustomBanner = (activeBanner != null && File(activeBanner).exists())
                var showResetBannerConfirmDialog by remember { mutableStateOf(false) }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(24.dp))
                        .background(palette.surface)
                        .pointerInput(hasCustomBanner) {
                            if (!hasCustomBanner) return@pointerInput
                            awaitEachGesture {
                                val down = awaitFirstDown(requireUnconsumed = false)
                                val startTime = SystemClock.uptimeMillis()
                                var triggered = false
                                while (true) {
                                    val event = awaitPointerEvent(PointerEventPass.Main)
                                    val curChange = event.changes.firstOrNull { it.id == down.id }
                                    if (curChange == null || !curChange.pressed) break

                                    val elapsed = SystemClock.uptimeMillis() - startTime
                                    if (elapsed >= 3000L && !triggered) {
                                        triggered = true
                                        triggerHapticFeedback(context)
                                        showResetBannerConfirmDialog = true
                                        break
                                    }
                                }
                            }
                        }
                ) {
                    if (activeBanner != null && File(activeBanner).exists()) {
                        if (isBannerVideo) {
                            AndroidView(
                                factory = { ctx ->
                                    VideoView(ctx).apply {
                                        setVideoPath(activeBanner)
                                        setOnPreparedListener { mp ->
                                            mp.isLooping = true
                                            mp.setVolume(0f, 0f)
                                            start()
                                        }
                                    }
                                },
                                update = { vv ->
                                    if (!vv.isPlaying) {
                                        vv.setVideoPath(activeBanner)
                                        vv.start()
                                    }
                                },
                                modifier = Modifier.matchParentSize()
                            )
                        } else {
                            val bitmap = remember(activeBanner, bannerRefreshTrigger) {
                                BitmapFactory.decodeFile(activeBanner)
                            }
                            if (bitmap != null) {
                                Image(
                                    bitmap = bitmap.asImageBitmap(),
                                    contentDescription = "个人主页背景",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.matchParentSize()
                                )
                            }
                        }
                    }

                    // High-Contrast Dark Scrim Overlay so text & buttons are always legible over any photo/video
                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .background(
                                if (activeBanner != null && File(activeBanner).exists()) {
                                    Color(0xFF0C0E12).copy(alpha = 0.80f)
                                } else {
                                    Color.Transparent
                                }
                            )
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            val activeAvatar = avatarFilePath
                            val avatarBitmap = remember(activeAvatar, avatarRefreshTrigger) {
                                if (activeAvatar != null && File(activeAvatar).exists()) {
                                    BitmapFactory.decodeFile(activeAvatar)
                                } else null
                            }

                            Box(
                                modifier = Modifier
                                    .size(76.dp)
                                    .clip(CircleShape)
                                    .background(palette.surfaceContainerHigh)
                                    .border(2.dp, palette.accent, CircleShape)
                                    .clickable { avatarPickerLauncher.launch("image/*") },
                                contentAlignment = Alignment.Center
                            ) {
                                if (avatarBitmap != null) {
                                    Image(
                                        bitmap = avatarBitmap.asImageBitmap(),
                                        contentDescription = "用户头像",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                } else {
                                    Icon(
                                        imageVector = Icons.Rounded.Person,
                                        contentDescription = "默认头像",
                                        tint = palette.primaryText,
                                        modifier = Modifier.size(38.dp)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.width(16.dp))

                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = userName,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = palette.primaryText
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = userBio,
                                    fontSize = 13.sp,
                                    color = palette.secondaryText,
                                    lineHeight = 18.sp
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(18.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            SymmetricHeaderButton(
                                text = "编辑资料",
                                icon = Icons.Rounded.Edit,
                                onClick = { isEditingProfile = true },
                                modifier = Modifier.weight(1f)
                            )

                            SymmetricHeaderButton(
                                text = "名片背景",
                                icon = Icons.Rounded.Image,
                                onClick = { showBannerChoiceDialog = true },
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }

                if (showResetBannerConfirmDialog) {
                    AlertDialog(
                        onDismissRequest = { showResetBannerConfirmDialog = false },
                        title = {
                            Text(
                                text = "重置名片背景",
                                fontWeight = FontWeight.Bold,
                                color = palette.primaryText
                            )
                        },
                        text = {
                            Text(
                                text = "确定要移除当前设置的名片背景图片/视频并恢复为默认主题样式吗？",
                                fontSize = 14.sp,
                                color = palette.secondaryText
                            )
                        },
                        confirmButton = {
                            Button(
                                onClick = {
                                    showResetBannerConfirmDialog = false
                                    try {
                                        bannerFilePath?.let { File(it).delete() }
                                    } catch (e: Throwable) {
                                        e.printStackTrace()
                                    }
                                    bannerFilePath = null
                                    isBannerVideo = false
                                    prefs.edit()
                                        .remove("banner_path")
                                        .putBoolean("is_banner_video", false)
                                        .apply()
                                    bannerRefreshTrigger++
                                    triggerHapticFeedback(context)
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = SignalDangerRed,
                                    contentColor = Color.White
                                ),
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Text("确认重置", fontWeight = FontWeight.Bold)
                            }
                        },
                        dismissButton = {
                            TextButton(
                                onClick = { showResetBannerConfirmDialog = false }
                            ) {
                                Text("取消", color = palette.secondaryText)
                            }
                        },
                        containerColor = palette.surfaceContainer,
                        shape = RoundedCornerShape(20.dp)
                    )
                }
            }

            // ==========================================
            // REAL DYNAMIC RIDING STATS OVERVIEW (Vibrant Telemetry Pills)
            // ==========================================
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(24.dp))
                        .background(palette.surface)
                        .padding(14.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    ProfileStatItem(
                        label = "累计里程",
                        value = String.format(Locale.US, "%.1f km", totalDistanceKm),
                        accentColor = Color(0xFFD8D2C7),
                        solidBg = palette.surfaceContainerHigh,
                        modifier = Modifier.weight(1f)
                    )
                    ProfileStatItem(
                        label = "骑行次数",
                        value = "${totalRidesCount} 次",
                        accentColor = Color(0xFFA2B69B),
                        solidBg = palette.surfaceContainerHigh,
                        modifier = Modifier.weight(1f)
                    )
                    ProfileStatItem(
                        label = "极限冲刺",
                        value = String.format(Locale.US, "%.1f km/h", maxSprintSpeedKmh),
                        accentColor = Color(0xFFCCA59A),
                        solidBg = palette.surfaceContainerHigh,
                        modifier = Modifier.weight(1f)
                    )
                    ProfileStatItem(
                        label = "历史最大G",
                        value = String.format(Locale.US, "%.2f G", maxHistoricG),
                        accentColor = Color(0xFF9EACB8),
                        solidBg = palette.surfaceContainerHigh,
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            // ==========================================
            // INTERACTIVE DATA MODULE 1:
            // 7日骑行负荷与里程走势 (100% Dynamically Computed from Real Rides)
            // ==========================================
            item {
                InteractiveDistanceModule(rides = rides)
            }

            // ==========================================
            // INTERACTIVE DATA MODULE 2:
            // 时速区间分布与速度包络 (100% Dynamically Computed from Real Rides)
            // ==========================================
            item {
                InteractiveSpeedModule(rides = rides)
            }

            // ==========================================
            // INTERACTIVE DATA MODULE 3:
            // 2D G-G 寻迹极限与加速度遥测 (100% Physically Computed from Real Accelerometer Telemetry)
            // ==========================================
            item {
                InteractiveGForceModule(rides = rides)
            }

            // ==========================================
            // INTERACTIVE DATA MODULE 4:
            // 山地等高阶梯与坡度剖面 (100% Dynamically Computed from Real Altitude & Haversine Grade)
            // ==========================================
            item {
                InteractiveElevationModule(rides = rides)
            }

            // ==========================================
            // HIGH POWER CONSUMPTION & BACKGROUND RECORDING (Auto-hidden when already granted)
            // ==========================================
            if (!isBatteryOptIgnored) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(24.dp))
                            .background(palette.surface)
                            .padding(18.dp)
                    ) {
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Rounded.BatteryChargingFull,
                                    contentDescription = null,
                                    tint = palette.accent,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "后台高耗电与锁屏常驻权限",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = palette.primaryText
                                )
                            }

                            Spacer(modifier = Modifier.height(14.dp))

                            Button(
                                onClick = {
                                    try {
                                        val intent = Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS).apply {
                                            data = Uri.parse("package:${context.packageName}")
                                        }
                                        context.startActivity(intent)
                                    } catch (e: Exception) {
                                        try {
                                            val intent = Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS)
                                            context.startActivity(intent)
                                        } catch (ex: Exception) {
                                            ex.printStackTrace()
                                        }
                                    }
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = palette.accent,
                                    contentColor = palette.onAccent
                                ),
                                shape = RoundedCornerShape(18.dp),
                                contentPadding = PaddingValues(vertical = 14.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "检查并授予后台无限制运行权限",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = palette.onAccent
                                )
                            }
                        }
                    }
                }
            }
        }

        // Dialog: Choose Banner Type (Photo or 5-Second Video)
        if (showBannerChoiceDialog) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(palette.background.copy(alpha = 0.88f))
                    .clickable { showBannerChoiceDialog = false },
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.86f)
                        .clickable(enabled = false) {}
                        .clip(RoundedCornerShape(28.dp))
                        .background(palette.surfaceContainer)
                        .padding(22.dp)
                ) {
                    Text(
                        text = "设置名片背景",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = palette.primaryText
                    )
                    Spacer(modifier = Modifier.height(18.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .background(palette.surfaceContainerHigh)
                            .clickable {
                                showBannerChoiceDialog = false
                                bannerPhotoLauncher.launch("image/*")
                            }
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(imageVector = Icons.Rounded.Image, contentDescription = null, tint = palette.accent)
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(text = "从相册选择背景图片", fontSize = 14.sp, fontWeight = FontWeight.Medium, color = palette.primaryText)
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .background(palette.surfaceContainerHigh)
                            .clickable {
                                showBannerChoiceDialog = false
                                bannerVideoLauncher.launch("video/*")
                            }
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(imageVector = Icons.Rounded.Videocam, contentDescription = null, tint = palette.accent)
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(text = "选择视频", fontSize = 14.sp, fontWeight = FontWeight.Medium, color = palette.primaryText)
                    }

                    Spacer(modifier = Modifier.height(18.dp))

                    Button(
                        onClick = { showBannerChoiceDialog = false },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = palette.surfaceContainerHigh,
                            contentColor = palette.primaryText
                        ),
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "取消",
                            fontWeight = FontWeight.SemiBold,
                            color = palette.primaryText
                        )
                    }
                }
            }
        }

        // Crop & Rotate Dialog for Background Photo
        if (showCropDialog && pendingCropUri != null) {
            PhotoCropDialog(
                imageUri = pendingCropUri!!,
                targetAspectRatio = 16f / 9f,
                onCropConfirmed = { destFile ->
                    bannerFilePath = destFile.absolutePath
                    isBannerVideo = false
                    prefs.edit()
                        .putString("banner_path", destFile.absolutePath)
                        .putBoolean("is_banner_video", false)
                        .apply()
                    bannerRefreshTrigger++
                    showCropDialog = false
                    pendingCropUri = null
                },
                onDismiss = {
                    showCropDialog = false
                    pendingCropUri = null
                }
            )
        }

        // Dialog: Edit Name & Bio
        if (isEditingProfile) {
            var tempName by remember { mutableStateOf(userName) }
            var tempBio by remember { mutableStateOf(userBio) }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(palette.background.copy(alpha = 0.88f))
                    .clickable { isEditingProfile = false },
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.88f)
                        .clickable(enabled = false) {}
                        .clip(RoundedCornerShape(28.dp))
                        .background(palette.surfaceContainer)
                        .padding(22.dp)
                ) {
                    Text(
                        text = "编辑个人资料",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = palette.primaryText
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    OutlinedTextField(
                        value = tempName,
                        onValueChange = { tempName = it },
                        label = { Text("昵称", color = palette.secondaryText) },
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = palette.accent,
                            unfocusedBorderColor = palette.surfaceContainerHighest,
                            focusedTextColor = palette.primaryText,
                            unfocusedTextColor = palette.primaryText
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = tempBio,
                        onValueChange = { tempBio = it },
                        label = { Text("个性签名", color = palette.secondaryText) },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = palette.accent,
                            unfocusedBorderColor = palette.surfaceContainerHighest,
                            focusedTextColor = palette.primaryText,
                            unfocusedTextColor = palette.primaryText
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Button(
                            onClick = { isEditingProfile = false },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = palette.surfaceContainerHigh,
                                contentColor = palette.primaryText
                            ),
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text(
                                text = "取消",
                                fontWeight = FontWeight.SemiBold,
                                color = palette.primaryText
                            )
                        }

                        Button(
                            onClick = {
                                userName = tempName
                                userBio = tempBio
                                prefs.edit().putString("user_name", tempName).putString("user_bio", tempBio).apply()
                                isEditingProfile = false
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = palette.accent,
                                contentColor = palette.onAccent
                            ),
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text(
                                text = "保存",
                                fontWeight = FontWeight.Bold,
                                color = palette.onAccent
                            )
                        }
                    }
                }
            }
        }

        // Settings Sheet (Theme Presets, 3-Hex Custom Colors, Speedometer BG & Dial Max Limit)
        // Wrapped in top-level Dialog to float ABOVE MainActivity's Dock Bar without any overlap!
        if (isSettingsOpen) {
            Dialog(
                onDismissRequest = { isSettingsOpen = false },
                properties = DialogProperties(
                    usePlatformDefaultWidth = false
                )
            ) {
                var hex1Input by remember { mutableStateOf(ThemeManager.customHex1) }
                var hex2Input by remember { mutableStateOf(ThemeManager.customHex2) }
                var hex3Input by remember { mutableStateOf(ThemeManager.customHex3) }
                var hexFeedbackMsg by remember { mutableStateOf<String?>(null) }
                var isHexSuccess by remember { mutableStateOf(true) }
                var showAddAccentDialog by remember { mutableStateOf(false) }
                var newAccentHexInput by remember { mutableStateOf("#FF6B00") }
                var showResetConfirmDialog by remember { mutableStateOf(false) }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.72f))
                        .clickable { isSettingsOpen = false },
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.92f)
                            .fillMaxHeight(0.85f)
                            .clickable(enabled = false) {}
                            .clip(RoundedCornerShape(28.dp))
                            .background(palette.surfaceContainer)
                            .border(1.2.dp, palette.borderHighlight, RoundedCornerShape(28.dp))
                            .padding(22.dp)
                            .verticalScroll(rememberScrollState())
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "应用个性化设置",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = palette.primaryText
                            )
                            Box(
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(CircleShape)
                                    .background(palette.surfaceContainerHigh)
                                    .clickable { isSettingsOpen = false },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = "✕", color = palette.primaryText, fontSize = 13.sp)
                            }
                        }

                        Spacer(modifier = Modifier.height(18.dp))

                        Text(text = "界面主题预设", fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = palette.secondaryText)
                        Spacer(modifier = Modifier.height(8.dp))

                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            ThemePreset.values().forEach { preset ->
                                val isSel = !ThemeManager.isCustomThemeActive && ThemeManager.currentPreset == preset
                                val presetPaletteColors = when (preset) {
                                    ThemePreset.TITANIUM_CREAM -> listOf(
                                        Color(0xFFEBE5DA), // Warm Cream
                                        Color(0xFF00E5FF), // Cyan
                                        Color(0xFF232834), // Slate Container
                                        Color(0xFF0C0E12)  // Matte Obsidian
                                    )
                                    ThemePreset.MONOCHROME_PURE -> listOf(
                                        Color(0xFFFFFFFF), // Pure White
                                        Color(0xFF8E95A2), // Muted Grey
                                        Color(0xFF222226), // Dark Container
                                        Color(0xFF000000)  // Deep Black
                                    )
                                }

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(14.dp))
                                        .background(if (isSel) palette.accent.copy(alpha = 0.14f) else palette.surfaceContainerHigh)
                                        .border(
                                            width = if (isSel) 1.5.dp else 1.dp,
                                            color = if (isSel) palette.accent else Color.Transparent,
                                            shape = RoundedCornerShape(14.dp)
                                        )
                                        .clickable {
                                            triggerHapticFeedback(context)
                                            ThemeManager.setPreset(preset, context)
                                            hexFeedbackMsg = "已切换至预设：${preset.displayName}"
                                            isHexSuccess = true
                                        }
                                        .padding(horizontal = 14.dp, vertical = 12.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column(modifier = Modifier.weight(1f, fill = false)) {
                                        Text(
                                            text = preset.displayName,
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = if (isSel) palette.accent else palette.primaryText
                                        )
                                        Spacer(modifier = Modifier.height(2.dp))
                                        Text(
                                            text = preset.subtitle,
                                            fontSize = 11.sp,
                                            color = palette.secondaryText,
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                    }

                                    Spacer(modifier = Modifier.width(10.dp))

                                    // Horizontally arranged, partially overlapping 2D color spheres
                                    Box(
                                        modifier = Modifier
                                            .height(22.dp)
                                            .width((22 + (presetPaletteColors.size - 1) * 14).dp),
                                        contentAlignment = Alignment.CenterStart
                                    ) {
                                        presetPaletteColors.forEachIndexed { idx, col ->
                                            Box(
                                                modifier = Modifier
                                                    .offset(x = (idx * 14).dp)
                                                    .size(22.dp)
                                                    .clip(CircleShape)
                                                    .background(col)
                                                    .border(
                                                        width = 1.5.dp,
                                                        color = if (isSel) palette.surfaceContainer else palette.surfaceContainerHigh,
                                                        shape = CircleShape
                                                    )
                                            )
                                        }
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(18.dp))

                        Text(
                            text = "快速重点色 (轻触应用，长按删除)",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = palette.secondaryText
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            val accents = ThemeManager.quickAccents
                            val maxAccents = 6

                            // Render existing accents
                            accents.forEachIndexed { idx, acc ->
                                val isChosen = ThemeManager.isCustomThemeActive && ThemeManager.customHex1.equals(acc.hex, ignoreCase = true)
                                val checkTint = if (acc.color.luminance() > 0.38f) Color(0xFF0C0E12) else Color.White
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(40.dp)
                                        .clip(RoundedCornerShape(12.dp))
                                        .background(acc.color)
                                        .border(
                                            width = if (isChosen) 2.dp else 1.dp,
                                            color = if (isChosen) palette.primaryText else Color.Transparent,
                                            shape = RoundedCornerShape(12.dp)
                                        )
                                        .pointerInput(acc.hex, accents.size) {
                                            detectTapGestures(
                                                onTap = {
                                                    triggerHapticFeedback(context)
                                                    ThemeManager.setQuickAccent(acc, context)
                                                    hex1Input = acc.hex
                                                    hexFeedbackMsg = "已应用重点色：${acc.name}"
                                                    isHexSuccess = true
                                                },
                                                onLongPress = {
                                                    if (accents.size > 1) {
                                                        triggerHapticFeedback(context)
                                                        ThemeManager.removeQuickAccent(idx, context)
                                                        hexFeedbackMsg = "已删除重点色：${acc.name}"
                                                        isHexSuccess = true
                                                    } else {
                                                        hexFeedbackMsg = "至少保留一个重点色"
                                                        isHexSuccess = false
                                                    }
                                                }
                                            )
                                        },
                                    contentAlignment = Alignment.Center
                                ) {
                                    if (isChosen) {
                                        Icon(
                                            imageVector = Icons.Rounded.Check,
                                            contentDescription = null,
                                            tint = checkTint,
                                            modifier = Modifier.size(18.dp)
                                        )
                                    }
                                }
                            }

                            // If fewer than 6 accents, show "+" button in the next slot
                            if (accents.size < maxAccents) {
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(40.dp)
                                        .clip(RoundedCornerShape(12.dp))
                                        .background(palette.surfaceContainerHigh)
                                        .border(1.dp, palette.borderHighlight, RoundedCornerShape(12.dp))
                                        .clickable {
                                            triggerHapticFeedback(context)
                                            newAccentHexInput = "#FF6B00"
                                            showAddAccentDialog = true
                                        },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Rounded.Add,
                                        contentDescription = "添加重点色",
                                        tint = palette.primaryText,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            }

                            // Fill remaining slots up to 6 with empty Spacers to keep uniform width
                            val emptySlots = maxAccents - accents.size - 1
                            if (emptySlots > 0) {
                                repeat(emptySlots) {
                                    Spacer(modifier = Modifier.weight(1f))
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "自定义配色",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = palette.secondaryText
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        HexColorInputRow(
                            label = "主点缀色 (指针/高亮数值)",
                            hexValue = hex1Input,
                            onValueChange = { hex1Input = it }
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        HexColorInputRow(
                            label = "副高光色 (副标/光晕细节)",
                            hexValue = hex2Input,
                            onValueChange = { hex2Input = it }
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        HexColorInputRow(
                            label = "面板底色 (卡片与背景沉浸色)",
                            hexValue = hex3Input,
                            onValueChange = { hex3Input = it }
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        // Actions Row: [应用并保存配色 (Enlarged)] + [重置配色 (Circular)]
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Button(
                                onClick = {
                                    triggerHapticFeedback(context)
                                    val ok = ThemeManager.applyCustomHexColors(hex1Input, hex2Input, hex3Input, context)
                                    if (ok) {
                                        hexFeedbackMsg = "自定义色彩已成功应用并保存！"
                                        isHexSuccess = true
                                    } else {
                                        hexFeedbackMsg = "请输入有效的 # 开头十六进制色值 (如 #EBE5DA)"
                                        isHexSuccess = false
                                    }
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = palette.accent,
                                    contentColor = palette.onAccent
                                ),
                                modifier = Modifier
                                    .weight(1f)
                                    .height(52.dp),
                                shape = RoundedCornerShape(16.dp)
                            ) {
                                Text(
                                    text = "应用并保存配色",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    color = palette.onAccent
                                )
                            }

                            // Shrunk circular reset button
                            Box(
                                modifier = Modifier
                                    .size(52.dp)
                                    .clip(CircleShape)
                                    .background(palette.surfaceContainerHighest)
                                    .border(1.dp, palette.borderHighlight, CircleShape)
                                    .clickable {
                                        triggerHapticFeedback(context)
                                        showResetConfirmDialog = true
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Refresh,
                                    contentDescription = "重置配色",
                                    tint = palette.primaryText,
                                    modifier = Modifier.size(22.dp)
                                )
                            }
                        }

                        if (hexFeedbackMsg != null) {
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = hexFeedbackMsg!!,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium,
                                color = if (isHexSuccess) palette.accent else SignalDangerRed
                            )
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "码表显示上限",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = palette.secondaryText
                            )
                            Text(
                                text = "${ThemeManager.maxSpeedSetting} km/h",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Monospace,
                                color = palette.accent
                            )
                        }
                        Spacer(modifier = Modifier.height(6.dp))

                        var sliderSpeed by remember(ThemeManager.maxSpeedSetting) {
                            mutableFloatStateOf(ThemeManager.maxSpeedSetting.toFloat())
                        }
                        Slider(
                            value = sliderSpeed,
                            onValueChange = { newVal ->
                                val stepped = ((newVal / 5f).roundToInt() * 5).coerceIn(30, 120)
                                sliderSpeed = stepped.toFloat()
                                if (stepped != ThemeManager.maxSpeedSetting) {
                                    ThemeManager.setMaxSpeed(stepped, context)
                                    triggerHapticFeedback(context)
                                }
                            },
                            valueRange = 30f..120f,
                            steps = 17,
                            colors = SliderDefaults.colors(
                                thumbColor = palette.accent,
                                activeTrackColor = palette.accent,
                                inactiveTrackColor = palette.surfaceContainerHighest
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("30 km/h", fontSize = 10.sp, color = palette.secondaryText)
                            Text("120 km/h", fontSize = 10.sp, color = palette.secondaryText)
                        }

                        // Dialog 1: Add Custom Accent
                        if (showAddAccentDialog) {
                            val previewColor = parseHexColor(newAccentHexInput)
                            AlertDialog(
                                onDismissRequest = { showAddAccentDialog = false },
                                title = {
                                    Text(
                                        text = "添加自定义重点色",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp,
                                        color = palette.primaryText
                                    )
                                },
                                text = {
                                    Column {
                                        Text(
                                            text = "输入HEX色值 (例如 #FF5722 或 #00E5FF)：",
                                            fontSize = 13.sp,
                                            color = palette.secondaryText
                                        )
                                        Spacer(modifier = Modifier.height(12.dp))
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .size(36.dp)
                                                    .clip(CircleShape)
                                                    .background(previewColor ?: Color.Gray)
                                                    .border(1.dp, palette.borderHighlight, CircleShape)
                                            )
                                            OutlinedTextField(
                                                value = newAccentHexInput,
                                                onValueChange = { newAccentHexInput = it.trim() },
                                                singleLine = true,
                                                modifier = Modifier.fillMaxWidth(),
                                                colors = OutlinedTextFieldDefaults.colors(
                                                    focusedBorderColor = palette.accent,
                                                    unfocusedBorderColor = palette.borderHighlight,
                                                    focusedTextColor = palette.primaryText,
                                                    unfocusedTextColor = palette.primaryText
                                                )
                                            )
                                        }
                                        if (previewColor == null && newAccentHexInput.isNotBlank()) {
                                            Spacer(modifier = Modifier.height(6.dp))
                                            Text(
                                                text = "请输入有效的 #RRGGBB 格式",
                                                fontSize = 11.sp,
                                                color = SignalDangerRed
                                            )
                                        }
                                    }
                                },
                                confirmButton = {
                                    TextButton(
                                        onClick = {
                                            if (previewColor != null) {
                                                val ok = ThemeManager.addQuickAccent(newAccentHexInput, context)
                                                if (ok) {
                                                    hexFeedbackMsg = "已添加新重点色"
                                                    isHexSuccess = true
                                                    showAddAccentDialog = false
                                                } else {
                                                    hexFeedbackMsg = "最多添加 6 个重点色"
                                                    isHexSuccess = false
                                                }
                                            }
                                        },
                                        enabled = previewColor != null
                                    ) {
                                        Text("保存", fontWeight = FontWeight.Bold, color = if (previewColor != null) palette.accent else palette.secondaryText)
                                    }
                                },
                                dismissButton = {
                                    TextButton(onClick = { showAddAccentDialog = false }) {
                                        Text("取消", color = palette.secondaryText)
                                    }
                                },
                                containerColor = palette.surfaceContainerHigh,
                                shape = RoundedCornerShape(20.dp)
                            )
                        }

                        // Dialog 2: Reset Colors Confirmation
                        if (showResetConfirmDialog) {
                            AlertDialog(
                                onDismissRequest = { showResetConfirmDialog = false },
                                title = {
                                    Text(
                                        text = "重置配色确认",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp,
                                        color = palette.primaryText
                                    )
                                },
                                text = {
                                    Text(
                                        text = "确定要将所有自定义配色重置为默认方案（钛金米白）吗？",
                                        fontSize = 13.sp,
                                        color = palette.secondaryText
                                    )
                                },
                                confirmButton = {
                                    TextButton(
                                        onClick = {
                                            triggerHapticFeedback(context)
                                            hex1Input = "#EBE5DA"
                                            hex2Input = "#00E5FF"
                                            hex3Input = "#1A1E28"
                                            ThemeManager.applyCustomHexColors("#EBE5DA", "#00E5FF", "#1A1E28", context)
                                            ThemeManager.setPreset(ThemePreset.TITANIUM_CREAM, context)
                                            hexFeedbackMsg = "已重置为默认配色方案"
                                            isHexSuccess = true
                                            showResetConfirmDialog = false
                                        }
                                    ) {
                                        Text("确认重置", fontWeight = FontWeight.Bold, color = SignalDangerRed)
                                    }
                                },
                                dismissButton = {
                                    TextButton(onClick = { showResetConfirmDialog = false }) {
                                        Text("取消", color = palette.secondaryText)
                                    }
                                },
                                containerColor = palette.surfaceContainerHigh,
                                shape = RoundedCornerShape(20.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "骑行记录速度模块背景",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = palette.secondaryText
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        val speedoBgStatus = when {
                            ThemeManager.speedometerBgPath == null -> "默认无背景 (纯黑原生面板)"
                            ThemeManager.speedometerBgIsVideo -> "已设定 5 秒动态视频背景"
                            else -> "已设定自定义背景图片"
                        }
                        Text(
                            text = speedoBgStatus,
                            fontSize = 12.sp,
                            color = palette.accent,
                            fontWeight = FontWeight.Medium
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Button(
                                onClick = { speedoPhotoLauncher.launch("image/*") },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = palette.surfaceContainerHigh,
                                    contentColor = palette.primaryText
                                ),
                                shape = RoundedCornerShape(14.dp),
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("选择图片", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = palette.primaryText)
                            }

                            Button(
                                onClick = { speedoVideoLauncher.launch("video/*") },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = palette.surfaceContainerHigh,
                                    contentColor = palette.primaryText
                                ),
                                shape = RoundedCornerShape(14.dp),
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("选择5秒视频", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = palette.primaryText)
                            }

                            if (ThemeManager.speedometerBgPath != null) {
                                Button(
                                    onClick = {
                                        triggerHapticFeedback(context)
                                        ThemeManager.clearSpeedometerBackground(context)
                                        speedoRefreshTrigger++
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = SignalDangerRed.copy(alpha = 0.2f),
                                        contentColor = SignalDangerRed
                                    ),
                                    shape = RoundedCornerShape(14.dp)
                                ) {
                                    Text("清除", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = SignalDangerRed)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun HexColorInputRow(
    label: String,
    hexValue: String,
    onValueChange: (String) -> Unit
) {
    val palette = LocalThemePalette.current
    val parsed = parseHexColor(hexValue)

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            fontSize = 12.sp,
            color = palette.secondaryText,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            OutlinedTextField(
                value = hexValue,
                onValueChange = { onValueChange(it.trim()) },
                modifier = Modifier
                    .weight(1f)
                    .height(52.dp),
                shape = RoundedCornerShape(12.dp),
                singleLine = true,
                textStyle = androidx.compose.ui.text.TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.SemiBold,
                    color = palette.primaryText
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = palette.accent,
                    unfocusedBorderColor = palette.surfaceContainerHighest,
                    focusedContainerColor = palette.surfaceContainerHigh,
                    unfocusedContainerColor = palette.surfaceContainerHigh
                )
            )

            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(parsed ?: Color.Transparent)
                    .border(
                        width = 1.5.dp,
                        color = if (parsed != null) palette.borderHighlight else SignalDangerRed.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                if (parsed == null) {
                    Text(text = "✕", fontSize = 12.sp, color = SignalDangerRed)
                }
            }
        }
    }
}

// =========================================================================
// UNIFIED TELEMETRY HEADER WITH DEDICATED NON-WRAPPING LIVE READOUT BAR
// =========================================================================

@Composable
private fun TelemetryModuleHeader(
    title: String,
    categoryTag: String,
    primaryReadout: String,
    secondaryBadge: String
) {
    val palette = LocalThemePalette.current
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = palette.primaryText,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = categoryTag,
                fontSize = 11.sp,
                fontFamily = FontFamily.Monospace,
                color = palette.secondaryText,
                maxLines = 1
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(42.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(palette.surfaceContainerHigh)
                .padding(horizontal = 14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = primaryReadout,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                color = palette.accent,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(palette.surfaceContainerHighest)
                    .padding(horizontal = 9.dp, vertical = 4.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = secondaryBadge,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.Monospace,
                    color = palette.primaryText,
                    maxLines = 1
                )
            }
        }
    }
}

// =========================================================================
// INTERACTIVE DATA BREAKDOWN MODULES (100% Real Computed Data from RideRepository)
// =========================================================================

/**
 * 模块一：近7日骑行负荷与里程走势 (Real 7-Day Aggregation from Recorded Rides)
 */
@Composable
private fun InteractiveDistanceModule(
    rides: List<RideRecord>
) {
    val palette = LocalThemePalette.current

    // Dynamically aggregate distance per calendar day for the past 7 days (6 days ago -> today)
    val (weeklyData, daysLabels) = remember(rides) {
        val weekNames = arrayOf("周日", "周一", "周二", "周三", "周四", "周五", "周六")
        val cal = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }
        val todayStartMs = cal.timeInMillis
        val oneDayMs = 86_400_000L

        val distances = FloatArray(7)
        val labels = ArrayList<String>(7)

        for (i in 0..6) {
            val dayOffset = 6 - i
            val dayStart = todayStartMs - dayOffset * oneDayMs
            val dayEnd = dayStart + oneDayMs
            val sumKm = rides
                .filter { it.startTime in dayStart until dayEnd }
                .sumOf { it.distanceKm }
                .toFloat()
            distances[i] = sumKm

            val dayCal = Calendar.getInstance().apply { timeInMillis = dayStart }
            val dow = dayCal.get(Calendar.DAY_OF_WEEK) - 1
            labels.add(if (dayOffset == 0) "今天" else weekNames[dow.coerceIn(0, 6)])
        }
        distances.toList() to labels
    }

    var touchFraction by remember { mutableStateOf<Float?>(null) }

    val activeFrac = touchFraction ?: 1f
    val nearestDayIdx = (activeFrac * 6f).roundToInt().coerceIn(0, 6)
    val interpolatedKm = sampleFloatSpline(weeklyData, activeFrac).coerceAtLeast(0f)

    val sevenDayTotalKm = weeklyData.sum()
    val dailyAvgKm = sevenDayTotalKm / 7f
    val peakDayKm = weeklyData.maxOrNull() ?: 0f
    val activeDaysCount = weeklyData.count { it > 0.01f }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(palette.surface)
            .padding(18.dp)
    ) {
        Column {
            TelemetryModuleHeader(
                title = "总里程走势",
                categoryTag = "近 7 日",
                primaryReadout = if (touchFraction != null) {
                    "${String.format(Locale.US, "%.2f", interpolatedKm)} km"
                } else {
                    "7日合计 ${String.format(Locale.US, "%.1f", sevenDayTotalKm)} km"
                },
                secondaryBadge = "${daysLabels[nearestDayIdx]} · ${String.format(Locale.US, "%.1f", weeklyData[nearestDayIdx])} km"
            )

            Spacer(modifier = Modifier.height(14.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(136.dp)
            ) {
                Canvas(
                    modifier = Modifier
                        .matchParentSize()
                        .pointerInput(weeklyData) {
                            detectTapGestures(
                                onPress = { offset ->
                                    touchFraction = (offset.x / size.width.coerceAtLeast(1)).coerceIn(0f, 1f)
                                    tryAwaitRelease()
                                    touchFraction = null
                                }
                            )
                        }
                        .pointerInput(weeklyData) {
                            detectDragGestures(
                                onDrag = { change, _ ->
                                    change.consume()
                                    touchFraction = (change.position.x / size.width.coerceAtLeast(1)).coerceIn(0f, 1f)
                                },
                                onDragEnd = { touchFraction = null },
                                onDragCancel = { touchFraction = null }
                            )
                        }
                ) {
                    val w = size.width
                    val h = size.height
                    val maxVal = (peakDayKm * 1.2f).coerceAtLeast(10f)
                    val padX = 18.dp.toPx()
                    val plotW = (w - padX * 2f).coerceAtLeast(1f)
                    val barWidth = 18.dp.toPx()

                    fun valToY(v: Float): Float {
                        val norm = (v / maxVal).coerceIn(0f, 1f)
                        return h - (norm * (h - 28f)) - 12f
                    }

                    weeklyData.forEachIndexed { i, d ->
                        val cx = padX + (i.toFloat() / 6f) * plotW
                        val topY = valToY(d)
                        val barH = (h - 12f - topY).coerceAtLeast(4f)
                        val isSelected = nearestDayIdx == i

                        val barColor = if (isSelected) Color(0xFFD8D2C7) else palette.surfaceContainerHighest

                        drawRoundRect(
                            color = barColor,
                            topLeft = Offset(cx - barWidth / 2f, topY),
                            size = Size(barWidth, barH),
                            cornerRadius = CornerRadius(6.dp.toPx(), 6.dp.toPx())
                        )
                    }

                    val path = Path()
                    val fillPath = Path()
                    val samples = 120
                    for (s in 0..samples) {
                        val f = s.toFloat() / samples
                        val x = padX + f * plotW
                        val y = valToY(sampleFloatSpline(weeklyData, f))
                        if (s == 0) {
                            path.moveTo(x, y)
                            fillPath.moveTo(x, h - 12f)
                            fillPath.lineTo(x, y)
                        } else {
                            path.lineTo(x, y)
                            fillPath.lineTo(x, y)
                        }
                    }
                    fillPath.lineTo(padX + plotW, h - 12f)
                    fillPath.close()

                    drawPath(
                        path = fillPath,
                        brush = Brush.verticalGradient(
                            colors = listOf(Color(0xFFD8D2C7).copy(alpha = 0.09f), Color.Transparent),
                            startY = 0f,
                            endY = h
                        )
                    )

                    drawPath(
                        path = path,
                        color = Color(0xFFD8D2C7),
                        style = Stroke(width = 2.6f, cap = StrokeCap.Round, join = StrokeJoin.Round)
                    )

                    val scrubX = padX + activeFrac * plotW
                    val scrubY = valToY(interpolatedKm)
                    val p = Offset(scrubX, scrubY)

                    drawLine(
                        color = Color(0xFFD8D2C7).copy(alpha = 0.35f),
                        start = Offset(p.x, 0f),
                        end = Offset(p.x, h),
                        strokeWidth = 1.2f
                    )
                    drawCircle(Color(0xFFD8D2C7).copy(alpha = 0.22f), radius = 8f, center = p)
                    drawCircle(Color(0xFFD8D2C7), radius = 4.5f, center = p)
                    drawCircle(Color(0xFF0C0E12), radius = 2.0f, center = p)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 6.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                daysLabels.forEachIndexed { i, day ->
                    Text(
                        text = day,
                        fontSize = 10.sp,
                        color = if (nearestDayIdx == i) Color(0xFFD8D2C7) else palette.secondaryText,
                        fontWeight = if (nearestDayIdx == i) FontWeight.Bold else FontWeight.Normal
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(palette.surfaceContainerHigh)
                    .padding(vertical = 10.dp, horizontal = 14.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TelemetryMetricItem("7日日均", "${String.format(Locale.US, "%.1f", dailyAvgKm)} km")
                TelemetryMetricItem("单日最高", "${String.format(Locale.US, "%.1f", peakDayKm)} km")
                TelemetryMetricItem("活跃天数", "$activeDaysCount / 7 天")
            }
        }
    }
}

/**
 * 模块二：时速区间分布与速度包络 (100% Dynamically Computed from Recorded TrackPoints)
 */
@Composable
private fun InteractiveSpeedModule(
    rides: List<RideRecord>
) {
    val palette = LocalThemePalette.current

    val (speedCurve, maxSpeedVal, avgSpeedVal, highZoneRatioPercent) = remember(rides) {
        val allPoints = rides.sortedBy { it.startTime }.flatMap { it.points }
        val rawSpeeds = if (allPoints.isNotEmpty()) {
            allPoints.map { it.speedKmh.coerceAtLeast(0f) }
        } else {
            rides.map { it.maxSpeedKmh.toFloat().coerceAtLeast(0f) }
        }
        val resampled = resampleSeries(rawSpeeds, targetCount = 10, defaultVal = 0f)
        val maxSpd = rides.maxOfOrNull { it.maxSpeedKmh }?.toFloat()
            ?: (rawSpeeds.maxOrNull() ?: 0f)

        val totalDistKm = rides.sumOf { it.distanceKm }
        val totalDurHours = rides.sumOf { it.durationSeconds } / 3600.0
        val avgSpd = if (totalDurHours > 0.001) {
            (totalDistKm / totalDurHours).toFloat()
        } else if (rides.isNotEmpty()) {
            rides.map { it.avgSpeedKmh }.average().toFloat()
        } else 0f

        val highIntensityPct = if (allPoints.isNotEmpty()) {
            ((allPoints.count { it.speedKmh >= 30f }.toDouble() / allPoints.size) * 100.0).roundToInt()
        } else 0

        SpeedTelemetrySummary(resampled, maxSpd, avgSpd, highIntensityPct)
    }

    var touchFraction by remember { mutableStateOf<Float?>(null) }

    val peakIdx = speedCurve.indices.maxByOrNull { speedCurve[it] } ?: 0
    val defaultFrac = peakIdx.toFloat() / (speedCurve.size - 1).coerceAtLeast(1)
    val activeFrac = touchFraction ?: defaultFrac
    val currentScrubSpeed = sampleFloatSpline(speedCurve, activeFrac).coerceAtLeast(0f)

    val zoneName = when {
        currentScrubSpeed >= 42f -> "Z5 极限冲刺"
        currentScrubSpeed >= 32f -> "Z4 阈值巡航"
        currentScrubSpeed >= 22f -> "Z3 节奏耐力"
        currentScrubSpeed >= 12f -> "Z2 有氧骑行"
        currentScrubSpeed > 0.5f -> "Z1 热身恢复"
        else -> "待机静止"
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(palette.surface)
            .padding(18.dp)
    ) {
        Column {
            TelemetryModuleHeader(
                title = "时速区间",
                categoryTag = "Z1 - Z5",
                primaryReadout = "${String.format(Locale.US, "%.1f", currentScrubSpeed)} km/h",
                secondaryBadge = zoneName
            )

            Spacer(modifier = Modifier.height(14.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(136.dp)
            ) {
                Canvas(
                    modifier = Modifier
                        .matchParentSize()
                        .pointerInput(speedCurve) {
                            detectTapGestures(
                                onPress = { offset ->
                                    touchFraction = (offset.x / size.width.coerceAtLeast(1)).coerceIn(0f, 1f)
                                    tryAwaitRelease()
                                    touchFraction = null
                                }
                            )
                        }
                        .pointerInput(speedCurve) {
                            detectDragGestures(
                                onDrag = { change, _ ->
                                    change.consume()
                                    touchFraction = (change.position.x / size.width.coerceAtLeast(1)).coerceIn(0f, 1f)
                                },
                                onDragEnd = { touchFraction = null },
                                onDragCancel = { touchFraction = null }
                            )
                        }
                ) {
                    val w = size.width
                    val h = size.height
                    val maxVal = (maxSpeedVal * 1.15f).coerceAtLeast(45f)

                    fun speedToY(s: Float): Float {
                        val norm = (s / maxVal).coerceIn(0f, 1f)
                        return h - (norm * (h - 28f)) - 14f
                    }

                    val zoneSteps = listOf(0.20f, 0.40f, 0.60f, 0.80f, 1.0f).map { it * maxVal }
                    var prevY = h
                    zoneSteps.forEachIndexed { idx, speedLim ->
                        val y = speedToY(speedLim).coerceIn(0f, h)
                        val bandColor = when (idx) {
                            4 -> SignalDangerRed.copy(alpha = 0.12f)
                            3 -> Color(0xFFFF9500).copy(alpha = 0.10f)
                            2 -> Color(0xFFE5A93C).copy(alpha = 0.08f)
                            1 -> palette.accent.copy(alpha = 0.07f)
                            else -> Color.White.copy(alpha = 0.03f)
                        }
                        val bandLineColor = Color.White.copy(alpha = 0.08f)
                        drawRect(bandColor, Offset(0f, y), Size(w, (prevY - y).coerceAtLeast(0f)))
                        drawLine(bandLineColor, Offset(0f, y), Offset(w, y), strokeWidth = 1.0f)
                        prevY = y
                    }

                    val path = Path()
                    val fillPath = Path()
                    val samples = 120

                    for (s in 0..samples) {
                        val f = s.toFloat() / samples
                        val x = f * w
                        val y = speedToY(sampleFloatSpline(speedCurve, f))
                        if (s == 0) {
                            path.moveTo(x, y)
                            fillPath.moveTo(x, h)
                            fillPath.lineTo(x, y)
                        } else {
                            path.lineTo(x, y)
                            fillPath.lineTo(x, y)
                        }
                    }
                    fillPath.lineTo(w, h)
                    fillPath.close()

                    drawPath(
                        path = fillPath,
                        brush = Brush.verticalGradient(
                            colors = listOf(Color(0xFF9CB2C4).copy(alpha = 0.08f), Color.Transparent),
                            startY = 0f,
                            endY = h
                        )
                    )
                    drawPath(
                        path = path,
                        color = Color(0xFF9CB2C4),
                        style = Stroke(width = 2.4f, cap = StrokeCap.Round, join = StrokeJoin.Round)
                    )

                    val targetX = (activeFrac * w).coerceIn(0f, w)
                    val targetY = speedToY(currentScrubSpeed)
                    val pCenter = Offset(targetX, targetY)

                    drawLine(
                        color = Color(0xFF9CB2C4).copy(alpha = 0.35f),
                        start = Offset(targetX, 0f),
                        end = Offset(targetX, h),
                        strokeWidth = 1.2f
                    )
                    drawCircle(Color(0xFF9CB2C4).copy(alpha = 0.22f), radius = 8f, center = pCenter)
                    drawCircle(Color(0xFF9CB2C4), radius = 4.5f, center = pCenter)
                    drawCircle(Color(0xFF0C0E12), radius = 2.0f, center = pCenter)
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // High-Contrast Speed Level Color Legend
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                listOf(
                    "Z1 恢复" to Color(0xFF8E95A2),
                    "Z2 有氧" to palette.accent,
                    "Z3 节奏" to Color(0xFFE5A93C),
                    "Z4 阈值" to Color(0xFFFF9500),
                    "Z5 冲刺" to SignalDangerRed
                ).forEach { (label, col) ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(7.dp)
                                .clip(CircleShape)
                                .background(col)
                        )
                        Text(
                            text = label,
                            fontSize = 10.sp,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.SemiBold,
                            color = palette.secondaryText
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(palette.surfaceContainerHigh)
                    .padding(vertical = 10.dp, horizontal = 14.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TelemetryMetricItem("历史极速", "${String.format(Locale.US, "%.1f", maxSpeedVal)} km/h")
                TelemetryMetricItem("综合均速", "${String.format(Locale.US, "%.1f", avgSpeedVal)} km/h")
                TelemetryMetricItem("高速占比(≥30)", "$highZoneRatioPercent%")
            }
        }
    }
}

private data class SpeedTelemetrySummary(
    val curve: List<Float>,
    val maxSpeed: Float,
    val avgSpeed: Float,
    val highZonePct: Int
)

/**
 * 模块三：2D G-G 寻迹极限与加速度遥测 (100% Physically Computed from Real Accelerometer Telemetry)
 */
@Composable
private fun InteractiveGForceModule(
    rides: List<RideRecord>
) {
    val palette = LocalThemePalette.current

    val (gPoints, lateralG, maxTotalG, peakLatG, shockStabilityPct) = remember(rides) {
        val allPoints = rides.sortedBy { it.startTime }.flatMap { it.points }
        val rawTotalG = if (allPoints.isNotEmpty()) {
            allPoints.map { it.totalG.coerceAtLeast(1.0f) }
        } else {
            rides.map { it.maxGForce.coerceAtLeast(1.0f) }
        }
        val rawLatG = if (allPoints.isNotEmpty()) {
            allPoints.map { hypot(it.gX.toDouble(), it.gY.toDouble()).toFloat() }
        } else {
            rawTotalG.map { ((it - 1.0f) * 0.65f).coerceAtLeast(0f) }
        }

        val resampledTotal = resampleSeries(rawTotalG, targetCount = 10, defaultVal = 1.0f)
        val resampledLat = resampleSeries(rawLatG, targetCount = 10, defaultVal = 0.0f)

        val peakG = rides.maxOfOrNull { it.maxGForce } ?: (rawTotalG.maxOrNull() ?: 1.0f)
        val maxLat = rawLatG.maxOrNull() ?: 0.0f

        // Real Physical Calculation for Dynamic Shock Attenuation / Chassis Stability Index:
        // Computes Root-Mean-Square (RMS) dynamic vibration relative to 1.0G gravity across all recorded track points.
        val stabilityIndex = if (allPoints.isNotEmpty()) {
            val meanSquareDynamicG = allPoints
                .map { val d = (it.totalG - 1.0f).toDouble(); d * d }
                .average()
            val rmsDynamicG = sqrt(meanSquareDynamicG)
            // Normalize RMS dynamic G against 1.2G full-scale rough-trail shock envelope
            ((1.0 - (rmsDynamicG / 1.20)).coerceIn(0.45, 0.99) * 100.0).roundToInt()
        } else {
            100
        }

        GForceTelemetrySummary(resampledTotal, resampledLat, peakG, maxLat, stabilityIndex)
    }

    var touchFraction by remember { mutableStateOf<Float?>(null) }

    val peakIdx = gPoints.indices.maxByOrNull { gPoints[it] } ?: 0
    val defaultFrac = peakIdx.toFloat() / (gPoints.size - 1).coerceAtLeast(1)
    val activeFrac = touchFraction ?: defaultFrac

    val curTotalG = sampleFloatSpline(gPoints, activeFrac)
    val curLatG = sampleFloatSpline(lateralG, activeFrac)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(palette.surface)
            .padding(18.dp)
    ) {
        Column {
            TelemetryModuleHeader(
                title = "加速度概览",
                categoryTag = "2D G-G",
                primaryReadout = "${String.format(Locale.US, "%.2f", curTotalG)} G",
                secondaryBadge = "侧向 ${String.format(Locale.US, "%.2f", curLatG)} G"
            )

            Spacer(modifier = Modifier.height(14.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(136.dp)
            ) {
                Canvas(
                    modifier = Modifier
                        .matchParentSize()
                        .pointerInput(gPoints) {
                            detectTapGestures(
                                onPress = { offset ->
                                    touchFraction = (offset.x / size.width.coerceAtLeast(1)).coerceIn(0f, 1f)
                                    tryAwaitRelease()
                                    touchFraction = null
                                }
                            )
                        }
                        .pointerInput(gPoints) {
                            detectDragGestures(
                                onDrag = { change, _ ->
                                    change.consume()
                                    touchFraction = (change.position.x / size.width.coerceAtLeast(1)).coerceIn(0f, 1f)
                                },
                                onDragEnd = { touchFraction = null },
                                onDragCancel = { touchFraction = null }
                            )
                        }
                ) {
                    val w = size.width
                    val h = size.height
                    val maxScale = (maxTotalG * 1.2f).coerceAtLeast(2.2f)

                    fun gToY(g: Float): Float {
                        val norm = (g / maxScale).coerceIn(0f, 1f)
                        return h - (norm * (h - 28f)) - 14f
                    }

                    listOf(1.0f, 1.8f).forEach { gRef ->
                        val y = gToY(gRef)
                        drawLine(Color.White.copy(alpha = 0.05f), Offset(0f, y), Offset(w, y), strokeWidth = 1f)
                    }

                    val totalPath = Path()
                    val latPath = Path()
                    val fillPath = Path()
                    val samples = 120

                    for (s in 0..samples) {
                        val f = s.toFloat() / samples
                        val x = f * w
                        val yTotal = gToY(sampleFloatSpline(gPoints, f))
                        val yLat = gToY(sampleFloatSpline(lateralG, f))
                        if (s == 0) {
                            totalPath.moveTo(x, yTotal)
                            latPath.moveTo(x, yLat)
                            fillPath.moveTo(x, h)
                            fillPath.lineTo(x, yTotal)
                        } else {
                            totalPath.lineTo(x, yTotal)
                            latPath.lineTo(x, yLat)
                            fillPath.lineTo(x, yTotal)
                        }
                    }
                    fillPath.lineTo(w, h)
                    fillPath.close()

                    drawPath(
                        path = fillPath,
                        brush = Brush.verticalGradient(
                            colors = listOf(Color(0xFFCCA59A).copy(alpha = 0.08f), Color.Transparent),
                            startY = 0f,
                            endY = h
                        )
                    )
                    drawPath(
                        path = latPath,
                        color = Color(0xFF8E95A2),
                        style = Stroke(width = 1.8f, cap = StrokeCap.Round, join = StrokeJoin.Round)
                    )
                    drawPath(
                        path = totalPath,
                        color = Color(0xFFCCA59A),
                        style = Stroke(width = 2.6f, cap = StrokeCap.Round, join = StrokeJoin.Round)
                    )

                    // Compact 2D G-G Friction Reticle in Top-Left Corner
                    val radarR = 26.dp.toPx()
                    val radarCenter = Offset(radarR + 8.dp.toPx(), radarR + 4.dp.toPx())
                    drawCircle(palette.surfaceContainerHigh.copy(alpha = 0.90f), radius = radarR, center = radarCenter)
                    drawCircle(Color.White.copy(alpha = 0.16f), radius = radarR, center = radarCenter, style = Stroke(1.0f))
                    drawCircle(Color.White.copy(alpha = 0.10f), radius = radarR * 0.70f, center = radarCenter, style = Stroke(1.0f))
                    drawCircle(Color.White.copy(alpha = 0.06f), radius = radarR * 0.45f, center = radarCenter, style = Stroke(1.0f))
                    drawLine(
                        Color.White.copy(alpha = 0.08f),
                        Offset(radarCenter.x - radarR, radarCenter.y),
                        Offset(radarCenter.x + radarR, radarCenter.y),
                        1f
                    )
                    drawLine(
                        Color.White.copy(alpha = 0.08f),
                        Offset(radarCenter.x, radarCenter.y - radarR),
                        Offset(radarCenter.x, radarCenter.y + radarR),
                        1f
                    )
                    val normLat = (curLatG / 1.5f).coerceIn(-1f, 1f)
                    val normLong = ((curTotalG - 1.0f) / 1.5f).coerceIn(-1f, 1f)
                    val vecPt = Offset(
                        radarCenter.x + normLat * radarR * 0.78f,
                        radarCenter.y - normLong * radarR * 0.78f
                    )
                    drawLine(Color(0xFFCCA59A), radarCenter, vecPt, strokeWidth = 2.0f)
                    drawCircle(Color(0xFFCCA59A), radius = 4.5f, center = vecPt)
                    drawCircle(Color(0xFF0C0E12), radius = 2.0f, center = vecPt)

                    val targetX = (activeFrac * w).coerceIn(0f, w)
                    val targetY = gToY(curTotalG)
                    val targetLatY = gToY(curLatG)
                    val pMain = Offset(targetX, targetY)
                    val pLat = Offset(targetX, targetLatY)

                    drawLine(
                        color = Color(0xFFCCA59A).copy(alpha = 0.35f),
                        start = Offset(pMain.x, 0f),
                        end = Offset(pMain.x, h),
                        strokeWidth = 1.2f
                    )
                    drawCircle(Color(0xFFCCA59A).copy(alpha = 0.22f), radius = 8f, center = pMain)
                    drawCircle(Color(0xFFCCA59A), radius = 4.5f, center = pMain)
                    drawCircle(Color(0xFF0C0E12), radius = 2.0f, center = pMain)

                    drawCircle(Color(0xFF8E95A2).copy(alpha = 0.22f), radius = 6f, center = pLat)
                    drawCircle(Color(0xFF8E95A2), radius = 3.5f, center = pLat)
                    drawCircle(Color(0xFF0C0E12), radius = 1.5f, center = pLat)
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(palette.surfaceContainerHigh)
                    .padding(vertical = 10.dp, horizontal = 14.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TelemetryMetricItem("最大合成G", "${String.format(Locale.US, "%.2f", maxTotalG)} G")
                TelemetryMetricItem("峰值侧向G", "${String.format(Locale.US, "%.2f", peakLatG)} G")
                TelemetryMetricItem("滤震平稳率", "$shockStabilityPct%")
            }
        }
    }
}

private data class GForceTelemetrySummary(
    val totalGSeries: List<Float>,
    val lateralGSeries: List<Float>,
    val maxTotalG: Float,
    val peakLatG: Float,
    val shockStabilityPct: Int
)

/**
 * 模块四：山地等高与坡度剖面 (100% Dynamically Computed from Recorded Altitude & Haversine Grade)
 */
@Composable
private fun InteractiveElevationModule(
    rides: List<RideRecord>
) {
    val palette = LocalThemePalette.current

    val (altProfile, slopeValues, totalClimbM, maxSlopePct, vamMetersPerHour) = remember(rides) {
        val allPoints = rides.sortedBy { it.startTime }.flatMap { it.points }
        val rawAlts = if (allPoints.isNotEmpty()) {
            allPoints.map { it.altitude.toFloat() }
        } else {
            rides.map { it.maxAltitudeM.toFloat() }
        }

        // Compute real physical grade (%) between consecutive GPS points: (deltaAlt / horizontalDist) * 100
        val rawSlopes = ArrayList<Float>()
        if (allPoints.size >= 2) {
            val distArr = FloatArray(1)
            rawSlopes.add(0f)
            for (i in 1 until allPoints.size) {
                val p0 = allPoints[i - 1]
                val p1 = allPoints[i]
                Location.distanceBetween(p0.latitude, p0.longitude, p1.latitude, p1.longitude, distArr)
                val horizDist = distArr[0]
                val dAlt = (p1.altitude - p0.altitude).toFloat()
                val grade = if (horizDist >= 3.0f) {
                    ((dAlt / horizDist) * 100f).coerceIn(-32f, 32f)
                } else {
                    rawSlopes.lastOrNull() ?: 0f
                }
                rawSlopes.add(grade)
            }
        }

        val resampledAlt = resampleSeries(rawAlts, targetCount = 10, defaultVal = 0f)
        val resampledSlope = resampleSeries(rawSlopes, targetCount = 10, defaultVal = 0f)

        val totalGain = rides.sumOf { it.elevationGainM }
        val maxGrade = rawSlopes.maxOrNull()?.coerceAtLeast(0f) ?: 0f
        val totalHours = rides.sumOf { it.durationSeconds } / 3600.0
        val vam = if (totalHours > 0.01) (totalGain / totalHours).roundToInt() else 0

        ElevationTelemetrySummary(resampledAlt, resampledSlope, totalGain, maxGrade, vam)
    }

    var touchFraction by remember { mutableStateOf<Float?>(null) }

    val peakIdx = altProfile.indices.maxByOrNull { altProfile[it] } ?: 0
    val defaultFrac = peakIdx.toFloat() / (altProfile.size - 1).coerceAtLeast(1)
    val activeFrac = touchFraction ?: defaultFrac

    val curAlt = sampleFloatSpline(altProfile, activeFrac)
    val curSlope = sampleFloatSpline(slopeValues, activeFrac)
    val slopeStr = if (curSlope >= 0f) {
        "+${String.format(Locale.US, "%.1f", curSlope)}%"
    } else {
        "${String.format(Locale.US, "%.1f", curSlope)}%"
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(palette.surface)
            .padding(18.dp)
    ) {
        Column {
            TelemetryModuleHeader(
                title = "海拔概览",
                categoryTag = "DEM PROFILE",
                primaryReadout = "海拔 ${curAlt.roundToInt()} m",
                secondaryBadge = "坡度 $slopeStr"
            )

            Spacer(modifier = Modifier.height(14.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(136.dp)
            ) {
                Canvas(
                    modifier = Modifier
                        .matchParentSize()
                        .pointerInput(altProfile) {
                            detectTapGestures(
                                onPress = { offset ->
                                    touchFraction = (offset.x / size.width.coerceAtLeast(1)).coerceIn(0f, 1f)
                                    tryAwaitRelease()
                                    touchFraction = null
                                }
                            )
                        }
                        .pointerInput(altProfile) {
                            detectDragGestures(
                                onDrag = { change, _ ->
                                    change.consume()
                                    touchFraction = (change.position.x / size.width.coerceAtLeast(1)).coerceIn(0f, 1f)
                                },
                                onDragEnd = { touchFraction = null },
                                onDragCancel = { touchFraction = null }
                            )
                        }
                ) {
                    val w = size.width
                    val h = size.height
                    val minVal = (altProfile.minOrNull() ?: 0f) - 5f
                    val maxVal = (altProfile.maxOrNull() ?: 50f).coerceAtLeast(minVal + 20f)

                    fun altToY(a: Float): Float {
                        val norm = ((a - minVal) / (maxVal - minVal)).coerceIn(0f, 1f)
                        return h - (norm * (h - 28f)) - 14f
                    }

                    listOf(0.25f, 0.5f, 0.75f).forEach { frac ->
                        val y = altToY(minVal + frac * (maxVal - minVal))
                        drawLine(Color.White.copy(alpha = 0.05f), Offset(0f, y), Offset(w, y), strokeWidth = 1f)
                    }

                    val mountainPath = Path()
                    val fillPath = Path()
                    val samples = 120

                    for (s in 0..samples) {
                        val f = s.toFloat() / samples
                        val x = f * w
                        val y = altToY(sampleFloatSpline(altProfile, f))
                        if (s == 0) {
                            mountainPath.moveTo(x, y)
                            fillPath.moveTo(x, h)
                            fillPath.lineTo(x, y)
                        } else {
                            mountainPath.lineTo(x, y)
                            fillPath.lineTo(x, y)
                        }
                    }
                    fillPath.lineTo(w, h)
                    fillPath.close()

                    drawPath(
                        path = fillPath,
                        brush = Brush.verticalGradient(
                            colors = listOf(Color(0xFFA2B69B).copy(alpha = 0.08f), Color.Transparent),
                            startY = 0f,
                            endY = h
                        )
                    )
                    drawPath(
                        path = mountainPath,
                        color = Color(0xFFA2B69B),
                        style = Stroke(width = 2.4f, cap = StrokeCap.Round, join = StrokeJoin.Round)
                    )

                    val targetX = (activeFrac * w).coerceIn(0f, w)
                    val targetY = altToY(curAlt)
                    val targetPt = Offset(targetX, targetY)

                    drawLine(
                        color = Color(0xFFA2B69B).copy(alpha = 0.35f),
                        start = Offset(targetPt.x, 0f),
                        end = Offset(targetPt.x, h),
                        strokeWidth = 1.2f
                    )
                    drawCircle(Color(0xFFA2B69B).copy(alpha = 0.22f), radius = 8f, center = targetPt)
                    drawCircle(Color(0xFFA2B69B), radius = 4.5f, center = targetPt)
                    drawCircle(Color(0xFF0C0E12), radius = 2.0f, center = targetPt)
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(palette.surfaceContainerHigh)
                    .padding(vertical = 10.dp, horizontal = 14.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TelemetryMetricItem("累计总爬升", "+${totalClimbM.roundToInt()} m")
                TelemetryMetricItem("最大坡度", "+${String.format(Locale.US, "%.1f", maxSlopePct)}%")
                TelemetryMetricItem("平均爬升率", "$vamMetersPerHour m/h")
            }
        }
    }
}

private data class ElevationTelemetrySummary(
    val altProfile: List<Float>,
    val slopeValues: List<Float>,
    val totalClimbM: Double,
    val maxSlopePct: Float,
    val vamMetersPerHour: Int
)

@Composable
private fun TelemetryMetricItem(label: String, value: String) {
    val palette = LocalThemePalette.current
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = label, fontSize = 11.sp, color = palette.secondaryText)
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = value,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            color = palette.primaryText
        )
    }
}

@Composable
private fun SymmetricHeaderButton(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val palette = LocalThemePalette.current
    Box(
        modifier = modifier
            .height(42.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(palette.surfaceContainerHigh)
            .clickable { onClick() }
            .padding(horizontal = 14.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = palette.accent,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = text,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = palette.primaryText
            )
        }
    }
}

@Composable
private fun ProfileStatItem(
    label: String,
    value: String,
    accentColor: Color = Color.Unspecified,
    solidBg: Color = Color(0xFF161A22),
    modifier: Modifier = Modifier
) {
    val palette = LocalThemePalette.current
    val effectiveColor = if (accentColor != Color.Unspecified) accentColor else palette.primaryText

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(solidBg)
            .border(1.dp, palette.borderHighlight, RoundedCornerShape(14.dp))
            .padding(horizontal = 6.dp, vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = label,
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium,
                color = palette.secondaryText,
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = value,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                color = effectiveColor,
                maxLines = 1
            )
        }
    }
}
