package com.liquidvelo.app.ui.components

import androidx.compose.foundation.background
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.liquidvelo.app.theme.LocalThemePalette
import java.util.Locale

/**
 * Clean Fast-Responding G-Force Telemetry Card
 * - Two vertical rows:
 *   - Upper row: Instantaneous G-Force
 *   - Lower row: Peak impact G-Force
 */
@Composable
fun GForceRadarView(
    gX: Float = 0f,
    gY: Float = 0f,
    totalG: Float,
    peakG: Float,
    modifier: Modifier = Modifier
) {
    val palette = LocalThemePalette.current

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(palette.surface)
            .padding(18.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "实时加速度",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = palette.primaryText
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "实时加速度",
                    fontSize = 12.sp,
                    color = palette.secondaryText
                )
            }

            // Two Vertical Rows for G-Force: Top Real-Time, Bottom Peak
            Column(
                horizontalAlignment = Alignment.End
            ) {
                // TOP ROW: Instantaneous Real-Time G
                Row(verticalAlignment = Alignment.Bottom) {
                    Text(
                        text = String.format(Locale.US, "%.2f", totalG),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        color = palette.primaryText
                    )
                    Text(
                        text = " G",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        color = palette.accent,
                        modifier = Modifier.padding(bottom = 3.dp)
                    )
                }

                Spacer(modifier = Modifier.height(2.dp))

                // BOTTOM ROW: Small Font Peak G
                Text(
                    text = "最高峰值: ${String.format(Locale.US, "%.2f", peakG)} G",
                    fontSize = 12.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Medium,
                    color = palette.secondaryText
                )
            }
        }
    }
}
