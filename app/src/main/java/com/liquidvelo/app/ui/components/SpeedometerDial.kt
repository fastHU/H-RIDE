package com.liquidvelo.app.ui.components

import android.graphics.BitmapFactory
import android.widget.VideoView
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.liquidvelo.app.theme.LocalThemePalette
import com.liquidvelo.app.theme.ThemeManager
import java.io.File
import java.util.Locale

/**
 * Modern Native Material 3 Speedometer Cockpit Gauge
 * - Circular progress bar with opening facing downwards (135° to 45°, 270° sweep)
 * - Fills smoothly from 0 to maxSpeedSetting
 * - Speed display:
 *   - Upper row: Bold integer speed
 *   - Lower row: Decimal fraction directly aligned beneath the integer, NO leading dot, NO unit label
 * - Optional custom background: supports static photo or 5-second looping video
 */
@Composable
fun SpeedometerDial(
    speedKmh: Float,
    maxRecordedSpeed: Float = 0f,
    modifier: Modifier = Modifier
) {
    val palette = LocalThemePalette.current
    val maxSpeed = ThemeManager.maxSpeedSetting.toFloat().coerceAtLeast(20f)

    val speedClamped = speedKmh.coerceIn(0f, 99.9f)
    val speedInt = speedClamped.toInt()
    val speedDec = ((speedClamped - speedInt) * 10).toInt()
    val formattedInt = String.format(Locale.US, "%02d", speedInt)

    val progress = (speedClamped / maxSpeed).coerceIn(0f, 1f)
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = spring(dampingRatio = 0.72f, stiffness = 420f),
        label = "speed_arc_progress"
    )

    val bgPath = ThemeManager.speedometerBgPath
    val hasCustomBg = bgPath != null && File(bgPath).exists()

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(palette.surface)
            .padding(vertical = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        // Render custom background image or looping video if configured
        if (hasCustomBg) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .clip(RoundedCornerShape(24.dp))
            ) {
                if (ThemeManager.speedometerBgIsVideo) {
                    AndroidView(
                        factory = { ctx ->
                            VideoView(ctx).apply {
                                setVideoPath(bgPath)
                                setOnPreparedListener { mp ->
                                    mp.isLooping = true
                                    mp.setVolume(0f, 0f)
                                    mp.start()
                                }
                            }
                        },
                        modifier = Modifier.matchParentSize()
                    )
                } else {
                    val bitmap = remember(bgPath) {
                        try {
                            BitmapFactory.decodeFile(bgPath)
                        } catch (e: Throwable) {
                            null
                        }
                    }
                    if (bitmap != null) {
                        Image(
                            bitmap = bitmap.asImageBitmap(),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.matchParentSize()
                        )
                    }
                }

                // Semi-transparent dark overlay for crisp dial and text readability
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .background(Color.Black.copy(alpha = 0.45f))
                )
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier.size(220.dp),
                contentAlignment = Alignment.Center
            ) {
                Canvas(modifier = Modifier.size(220.dp)) {
                    val strokeW = 14.dp.toPx()
                    val minDim = size.minDimension
                    if (minDim <= strokeW * 2) return@Canvas
                    val radius = (minDim - strokeW) / 2f
                    if (radius <= 0f) return@Canvas
                    val center = Offset(size.width / 2f, size.height / 2f)

                    val startAngle = 135f
                    val totalSweep = 270f

                    // Track Background Arc
                    drawArc(
                        color = Color.White.copy(alpha = 0.12f),
                        startAngle = startAngle,
                        sweepAngle = totalSweep,
                        useCenter = false,
                        style = Stroke(width = strokeW, cap = StrokeCap.Round),
                        topLeft = Offset(center.x - radius, center.y - radius),
                        size = Size(radius * 2, radius * 2)
                    )

                    // Active Filled Progress Arc
                    if (animatedProgress > 0.005f) {
                        drawArc(
                            color = palette.accent,
                            startAngle = startAngle,
                            sweepAngle = totalSweep * animatedProgress,
                            useCenter = false,
                            style = Stroke(width = strokeW, cap = StrokeCap.Round),
                            topLeft = Offset(center.x - radius, center.y - radius),
                            size = Size(radius * 2, radius * 2)
                        )
                    }
                }

                // UPPER ROW: Bold Integer Speed centered right at the dead center of the circular progress arc
                Text(
                    text = formattedInt,
                    fontSize = 72.sp,
                    lineHeight = 72.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    color = palette.primaryText
                )

                // LOWER ROW: Decimal fraction moved down directly beneath the integer
                Text(
                    text = "$speedDec",
                    fontSize = 24.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    color = palette.secondaryAccent,
                    modifier = Modifier.offset(y = 48.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // OUTSIDE THE CIRCULAR PROGRESS BAR AT THE BOTTOM:
            Text(
                text = "最大速度",
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium,
                color = palette.secondaryText
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = String.format(Locale.US, "%.1f km/h", maxRecordedSpeed),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                color = palette.primaryText
            )
        }
    }
}
