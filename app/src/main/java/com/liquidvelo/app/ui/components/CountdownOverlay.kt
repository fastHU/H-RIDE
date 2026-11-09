package com.liquidvelo.app.ui.components

import android.content.Context
import android.os.Build
import android.os.SystemClock
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.DirectionsBike
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.liquidvelo.app.theme.LocalThemePalette
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.roundToInt

private enum class OverlayPhase {
    SLIDE_TO_START,
    COUNTING_DOWN
}

@Composable
fun CountdownOverlay(
    onCountdownFinished: () -> Unit,
    onCancel: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val palette = LocalThemePalette.current
    val density = LocalDensity.current
    val scope = rememberCoroutineScope()

    var phase by remember { mutableStateOf(OverlayPhase.SLIDE_TO_START) }

    // Countdown and Transition States
    var displayDigit by remember { mutableIntStateOf(3) }
    var sweepProgress by remember { mutableFloatStateOf(0f) }
    var hasFinished by remember { mutableStateOf(false) }
    var isZoomingOut by remember { mutableStateOf(false) }

    val vibrator = remember {
        context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
    }

    fun vibrateSingleTick() {
        try {
            if (vibrator != null && vibrator.hasVibrator()) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(18, 70))
                } else {
                    @Suppress("DEPRECATION")
                    vibrator.vibrate(18)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    // Vibrates twice when sliding finishes
    fun vibrateTwice() {
        try {
            if (vibrator != null && vibrator.hasVibrator()) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createWaveform(longArrayOf(0, 40, 80, 50), -1))
                } else {
                    @Suppress("DEPRECATION")
                    vibrator.vibrate(40)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun finishSafely() {
        if (hasFinished) return
        hasFinished = true
        onCountdownFinished()
    }

    // Countdown timer effect (only active when in COUNTING_DOWN phase)
    LaunchedEffect(phase) {
        if (phase == OverlayPhase.COUNTING_DOWN) {
            // Buffer to allow the countdown dial to smoothly blossom onto screen
            delay(160L)
            val totalDurationMs = 3000L
            val startTime = SystemClock.elapsedRealtime()
            var lastVibratedSecond = 4

            while (isActive && !hasFinished) {
                val elapsed = SystemClock.elapsedRealtime() - startTime
                val remainingMs = totalDurationMs - elapsed

                if (remainingMs <= 0L) {
                    sweepProgress = 1f
                    displayDigit = 1
                    // Transition: Zoom in and fade without showing GO!
                    isZoomingOut = true
                    delay(260L)
                    finishSafely()
                    break
                }

                sweepProgress = (elapsed.toFloat() / totalDurationMs).coerceIn(0f, 1f)
                val currentSecond = ceil(remainingMs / 1000.0).toInt().coerceIn(1, 3)

                if (currentSecond != lastVibratedSecond) {
                    displayDigit = currentSecond
                    vibrateSingleTick()
                    lastVibratedSecond = currentSecond
                }

                delay(16L)
            }
        }
    }

    val zoomScale by animateFloatAsState(
        targetValue = if (isZoomingOut) 1.55f else 1.0f,
        animationSpec = tween(durationMillis = 280, easing = FastOutSlowInEasing),
        label = "countdown_zoom_scale"
    )
    val zoomAlpha by animateFloatAsState(
        targetValue = if (isZoomingOut) 0.0f else 1.0f,
        animationSpec = tween(durationMillis = 260, easing = FastOutSlowInEasing),
        label = "countdown_zoom_alpha"
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.88f))
            .clickable(enabled = false) {},
        contentAlignment = Alignment.Center
    ) {
        AnimatedContent(
            targetState = phase,
            transitionSpec = {
                if (targetState == OverlayPhase.COUNTING_DOWN) {
                    (fadeIn(animationSpec = tween(durationMillis = 380, delayMillis = 60, easing = FastOutSlowInEasing)) +
                     scaleIn(initialScale = 0.76f, animationSpec = spring(dampingRatio = 0.72f, stiffness = 320f)))
                        .togetherWith(
                            fadeOut(animationSpec = tween(durationMillis = 200, easing = FastOutSlowInEasing)) +
                            scaleOut(targetScale = 0.88f, animationSpec = tween(durationMillis = 200, easing = FastOutSlowInEasing))
                        )
                } else {
                    fadeIn(animationSpec = tween(200)).togetherWith(fadeOut(animationSpec = tween(200)))
                }
            },
            label = "overlay_phase_transition",
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) { currentPhase ->
            if (currentPhase == OverlayPhase.SLIDE_TO_START) {
            // ==========================================
            // PHASE 1: Slide To Start Slider + Cancel Button
            // Possesses identical tactile spring physics & velocity deformation as AppleDockBar
            // ==========================================
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(horizontal = 24.dp)
            ) {
                Text(
                    text = "准备就绪",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = palette.primaryText
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "滑动下方滑块开启骑行遥测记录",
                    fontSize = 13.sp,
                    color = palette.secondaryText
                )

                Spacer(modifier = Modifier.height(42.dp))

                val trackWidth = 280.dp
                val trackHeight = 64.dp
                val handleSize = 52.dp

                BoxWithConstraints(
                    modifier = Modifier
                        .width(trackWidth)
                        .height(trackHeight)
                ) {
                    val maxTravel = trackWidth - handleSize - 12.dp
                    val maxTravelPx = with(density) { maxTravel.toPx() }.coerceAtLeast(1f)
                    val handleOffset = remember { Animatable(0f) }
                    var isHandleTouched by remember { mutableStateOf(false) }
                    var dragSpeedTarget by remember { mutableFloatStateOf(0f) }

                    // Continuous spring magnification on touch (same as AppleDockBar 1.34x)
                    val effectiveScale by animateFloatAsState(
                        targetValue = if (isHandleTouched) 1.28f else 1.0f,
                        animationSpec = spring(dampingRatio = 0.72f, stiffness = 420f),
                        label = "slide_handle_scale"
                    )

                    val stretchFactorX by animateFloatAsState(
                        targetValue = 1.0f + (dragSpeedTarget / 1800f).coerceIn(0f, 0.25f),
                        animationSpec = spring(dampingRatio = 0.78f, stiffness = 480f),
                        label = "slide_handle_stretch"
                    )

                    // Track base with fixed-coordinate pointer input (Zero resistance, 1:1 direct finger tracking)
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .shadow(
                                elevation = 16.dp,
                                shape = RoundedCornerShape(32.dp),
                                ambientColor = Color.Black.copy(alpha = 0.55f),
                                spotColor = Color.Black.copy(alpha = 0.65f)
                            )
                            .clip(RoundedCornerShape(32.dp))
                            .background(Color(0xFF0F1218))
                            .border(1.2.dp, Color.White.copy(alpha = 0.08f), RoundedCornerShape(32.dp))
                            .pointerInput(maxTravelPx) {
                                awaitEachGesture {
                                    val down = awaitFirstDown(requireUnconsumed = false)
                                    isHandleTouched = true
                                    vibrateSingleTick()

                                    var lastX = down.position.x
                                    var lastTime = SystemClock.uptimeMillis()

                                    do {
                                        val event = awaitPointerEvent()
                                        val curChange = event.changes.firstOrNull { it.id == down.id } ?: break
                                        val curX = curChange.position.x
                                        val curTime = SystemClock.uptimeMillis()

                                        val dx = curX - lastX
                                        val dt = (curTime - lastTime).coerceAtLeast(1L)
                                        val instantSpeed = abs(dx) / (dt / 1000f)
                                        dragSpeedTarget = (dragSpeedTarget * 0.65f) + (instantSpeed * 0.35f)

                                        // Direct 1:1 movement in static track coordinates
                                        val nextVal = (handleOffset.value + dx).coerceIn(0f, maxTravelPx)
                                        scope.launch { handleOffset.snapTo(nextVal) }

                                        curChange.consume()
                                        lastX = curX
                                        lastTime = curTime
                                    } while (event.changes.any { it.pressed })

                                    isHandleTouched = false
                                    dragSpeedTarget = 0f

                                    // Completion threshold: > 72% of full travel triggers transition
                                    if (handleOffset.value >= maxTravelPx * 0.72f) {
                                        vibrateTwice()
                                        scope.launch {
                                            // Spring snap handle smoothly to end of track
                                            handleOffset.animateTo(
                                                targetValue = maxTravelPx,
                                                animationSpec = spring(
                                                    dampingRatio = 0.85f,
                                                    stiffness = 600f
                                                )
                                            )
                                            delay(50L)
                                            phase = OverlayPhase.COUNTING_DOWN
                                        }
                                    } else {
                                        scope.launch {
                                            handleOffset.animateTo(
                                                targetValue = 0f,
                                                animationSpec = spring(
                                                    dampingRatio = 0.78f,
                                                    stiffness = 500f
                                                )
                                            )
                                        }
                                    }
                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "向右滑动开始 ❯❯❯",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = palette.secondaryText.copy(alpha = 0.65f),
                            letterSpacing = 1.sp
                        )
                    }

                    // Interactive Slider Handle (Renders strictly as a visual follower)
                    Box(
                        modifier = Modifier
                            .offset { IntOffset(x = handleOffset.value.roundToInt() + with(density) { 6.dp.roundToPx() }, y = with(density) { 6.dp.roundToPx() }) }
                            .size(handleSize)
                            .graphicsLayer {
                                scaleX = effectiveScale * stretchFactorX
                                scaleY = effectiveScale
                            }
                            .shadow(
                                elevation = if (isHandleTouched) 14.dp else 4.dp,
                                shape = CircleShape,
                                ambientColor = palette.accent.copy(alpha = 0.50f),
                                spotColor = palette.accent.copy(alpha = 0.65f)
                            )
                            .clip(CircleShape)
                            .background(palette.accent)
                            .border(1.2.dp, Color.White.copy(alpha = 0.14f), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.DirectionsBike,
                            contentDescription = "滑动把手",
                            tint = palette.onAccent,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(36.dp))

                // Cancel Button
                Box(
                    modifier = Modifier
                        .size(52.dp)
                        .clip(CircleShape)
                        .background(palette.surfaceContainerHigh)
                        .border(1.dp, palette.borderHighlight, CircleShape)
                        .clickable { onCancel() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Close,
                        contentDescription = "取消",
                        tint = palette.primaryText,
                        modifier = Modifier.size(22.dp)
                    )
                }
            }
        } else {
            // ==========================================
            // PHASE 2: Countdown 3, 2, 1 (Bold Digits)
            // Ends directly with zoom-out cross-fade transition without "GO"
            // ==========================================
            Box(
                modifier = Modifier
                    .graphicsLayer {
                        scaleX = zoomScale
                        scaleY = zoomScale
                        alpha = zoomAlpha
                    },
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(210.dp)
                        .clip(CircleShape)
                        .background(palette.surface)
                        .border(1.2.dp, palette.borderHighlight, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Canvas(modifier = Modifier.size(190.dp)) {
                        val strokeWidth = 8.dp.toPx()
                        drawCircle(
                            color = Color.White.copy(alpha = 0.10f),
                            style = Stroke(width = strokeWidth)
                        )
                        drawArc(
                            color = palette.accent,
                            startAngle = -90f,
                            sweepAngle = 360f * sweepProgress,
                            useCenter = false,
                            style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                        )
                    }

                    AnimatedContent(
                        targetState = displayDigit,
                        transitionSpec = {
                            scaleIn(animationSpec = tween(160)) + fadeIn() togetherWith
                                    scaleOut(animationSpec = tween(140)) + fadeOut()
                        },
                        label = "countdown_bold_digits"
                    ) { digit ->
                        Text(
                            text = digit.toString(),
                            fontSize = 92.sp,
                            fontWeight = FontWeight.Black,
                            fontFamily = FontFamily.Monospace,
                            color = palette.primaryText
                        )
                    }
                }
            }
        }
    }
}
}
