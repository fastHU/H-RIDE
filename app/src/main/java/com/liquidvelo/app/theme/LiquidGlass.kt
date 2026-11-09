package com.liquidvelo.app.theme

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

/**
 * Clean Material 3 Native Surface Modifier
 * - Completely removes all AI-style fake rim highlights and specular glare
 * - Clean, pure Android Material 3 elevation and rounded corners
 * - Crystal-clear readability
 */
fun Modifier.liquidGlass(
    shape: Shape = RoundedCornerShape(20.dp),
    backgroundColor: Color = GlassSurfaceDark,
    borderHighlightColor: Color = Color.Transparent, // No fake AI border highlights!
    elevation: Dp = 4.dp
): Modifier = this
    .shadow(
        elevation = elevation,
        shape = shape,
        ambientColor = Color.Black.copy(alpha = 0.35f),
        spotColor = Color.Black.copy(alpha = 0.5f)
    )
    .clip(shape)
    .background(backgroundColor, shape = shape)
    .border(
        width = 0.8.dp,
        color = Color.White.copy(alpha = 0.08f), // Subtle, uniform, elegant hairline divider
        shape = shape
    )

/**
 * Standard Native Material 3 Responsive Button Touch
 */
fun Modifier.liquidInteractiveButton(
    onClick: () -> Unit = {},
    shape: Shape = RoundedCornerShape(20.dp)
): Modifier = composed {
    val scale = remember { Animatable(1f) }
    val scope = rememberCoroutineScope()

    this
        .scale(scale.value)
        .pointerInput(Unit) {
            awaitEachGesture {
                awaitFirstDown(requireUnconsumed = false)
                scope.launch {
                    scale.animateTo(0.96f, spring(dampingRatio = 0.70f, stiffness = 450f))
                }

                val up = waitForUpOrCancellation()
                if (up != null) {
                    onClick()
                }

                scope.launch {
                    scale.animateTo(1f, spring(dampingRatio = 0.55f, stiffness = Spring.StiffnessMediumLow))
                }
            }
        }
}
