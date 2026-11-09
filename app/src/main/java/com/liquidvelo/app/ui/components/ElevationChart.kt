package com.liquidvelo.app.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.liquidvelo.app.model.RideTrackPoint
import com.liquidvelo.app.theme.LocalThemePalette
import java.util.Locale

private fun sampleElevationSpline(values: List<Double>, fraction: Float): Double {
    if (values.isEmpty()) return 0.0
    if (values.size == 1) return values.first()
    val clamped = fraction.coerceIn(0f, 1f)
    val exactIdx = clamped * (values.size - 1)
    val i0 = exactIdx.toInt().coerceIn(0, values.size - 2)
    val i1 = (i0 + 1).coerceAtMost(values.size - 1)
    val u = (exactIdx - i0).coerceIn(0f, 1f)
    val smoothU = u * u * (3f - 2f * u)
    return values[i0] + (values[i1] - values[i0]) * smoothU
}

@Composable
fun ElevationChart(
    points: List<RideTrackPoint>,
    elevationGainM: Double,
    currentAltitudeM: Double = 0.0,
    modifier: Modifier = Modifier
) {
    val palette = LocalThemePalette.current
    var touchFraction by remember { mutableStateOf<Float?>(null) }

    val altList = remember(points, currentAltitudeM) {
        when {
            points.size >= 2 -> points.map { it.altitude }
            points.size == 1 -> listOf(points[0].altitude, points[0].altitude)
            else -> listOf(currentAltitudeM, currentAltitudeM)
        }
    }

    val rawMin = altList.minOrNull() ?: currentAltitudeM
    val rawMax = altList.maxOrNull() ?: currentAltitudeM
    val plotMinAlt = rawMin - 2.0
    val plotMaxAlt = (rawMax + 2.0).coerceAtLeast(plotMinAlt + 6.0)

    val activeFrac = touchFraction ?: 1f
    val currentAlt = sampleElevationSpline(altList, activeFrac)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(palette.surface)
            .padding(18.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "海拔轮廓分析",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = palette.primaryText
                )
                Text(
                    text = "累计爬升 +${String.format(Locale.US, "%.1f", elevationGainM)} m",
                    fontSize = 12.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.SemiBold,
                    color = palette.accent
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Dedicated Non-Wrapping Readout Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(palette.surfaceContainerHigh)
                    .padding(horizontal = 14.dp, vertical = 9.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${String.format(Locale.US, "%.1f", currentAlt)} m",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    color = palette.primaryText,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = "最高 ${String.format(Locale.US, "%.1f", rawMax)}m · 最低 ${String.format(Locale.US, "%.1f", rawMin)}m",
                    fontSize = 11.sp,
                    fontFamily = FontFamily.Monospace,
                    color = palette.secondaryText,
                    maxLines = 1
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
            ) {
                Canvas(
                    modifier = Modifier
                        .matchParentSize()
                        .pointerInput(altList) {
                            detectTapGestures(
                                onPress = { offset ->
                                    touchFraction = (offset.x / size.width.coerceAtLeast(1)).coerceIn(0f, 1f)
                                    tryAwaitRelease()
                                    touchFraction = null
                                }
                            )
                        }
                        .pointerInput(altList) {
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
                    if (altList.size < 2) return@Canvas
                    val width = size.width
                    val height = size.height
                    val altSpan = (plotMaxAlt - plotMinAlt).toFloat().coerceAtLeast(1f)

                    fun altToY(alt: Double): Float {
                        val norm = ((alt - plotMinAlt).toFloat() / altSpan).coerceIn(0f, 1f)
                        return height - (norm * (height - 28f)) - 14f
                    }

                    val curvePath = Path()
                    val fillPath = Path()
                    val samples = 100

                    for (s in 0..samples) {
                        val f = s.toFloat() / samples
                        val x = f * width
                        val y = altToY(sampleElevationSpline(altList, f))
                        if (s == 0) {
                            curvePath.moveTo(x, y)
                            fillPath.moveTo(x, height)
                            fillPath.lineTo(x, y)
                        } else {
                            curvePath.lineTo(x, y)
                            fillPath.lineTo(x, y)
                        }
                    }

                    fillPath.lineTo(width, height)
                    fillPath.close()

                    drawPath(
                        path = fillPath,
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                palette.accent.copy(alpha = 0.22f),
                                Color.Transparent
                            ),
                            startY = 0f,
                            endY = height
                        )
                    )

                    drawPath(
                        path = curvePath,
                        color = palette.accent,
                        style = Stroke(width = 2.6f, cap = StrokeCap.Round, join = StrokeJoin.Round)
                    )

                    val scrubX = (activeFrac * width).coerceIn(0f, width)
                    val scrubY = altToY(currentAlt)
                    val p = Offset(scrubX, scrubY)

                    drawLine(
                        color = palette.primaryText.copy(alpha = 0.35f),
                        start = Offset(p.x, 0f),
                        end = Offset(p.x, height),
                        strokeWidth = 1.4f
                    )
                    drawCircle(
                        color = palette.accent.copy(alpha = 0.32f),
                        radius = 10f,
                        center = p
                    )
                    drawCircle(
                        color = palette.accent,
                        radius = 5.5f,
                        center = p
                    )
                    drawCircle(
                        color = palette.onAccent,
                        radius = 2.5f,
                        center = p
                    )
                }
            }
        }
    }
}
