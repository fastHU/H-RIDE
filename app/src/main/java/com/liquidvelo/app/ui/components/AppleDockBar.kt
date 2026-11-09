package com.liquidvelo.app.ui.components

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.DirectionsBike
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.History
import androidx.compose.material.icons.rounded.MyLocation
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.liquidvelo.app.theme.LocalThemePalette
import kotlinx.coroutines.launch
import kotlin.math.abs
import kotlin.math.roundToInt
import kotlin.math.sin
import kotlin.math.sqrt

enum class NavigationTab(val title: String, val icon: ImageVector) {
    RIDE("骑行", Icons.AutoMirrored.Rounded.DirectionsBike),
    HISTORY("记录", Icons.Rounded.History),
    TOOLS("工具", Icons.Rounded.Build),
    PROFILE("我的", Icons.Rounded.Person)
}

/**
 * Premium Apple-grade Dock Bar
 * - Dock bar base: Height 64.dp, RoundedCornerShape(32.dp), subtle dark glass styling
 * - Active slider pill: Expands visibly OUTSIDE the dock base boundaries when touched/held or in transit
 *   (Base height 52.dp, scales up to 1.40x -> 72.8.dp, visibly protruding beyond the 64.dp dock base)
 * - Seamless linear flight scale envelope without awkward separate steps
 * - Unclipped parent container so slider breakouts are vivid and tactile
 */
@Composable
fun AppleDockBar(
    currentTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    onLocationClick: (() -> Unit)? = null,
    onStartRideClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val palette = LocalThemePalette.current
    val tabs = NavigationTab.values()
    val density = LocalDensity.current
    val scope = rememberCoroutineScope()

    val vibrator = remember {
        context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
    }

    fun vibrateTick() {
        try {
            if (vibrator != null && vibrator.hasVibrator()) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(14, 70))
                } else {
                    @Suppress("DEPRECATION")
                    vibrator.vibrate(14)
                }
            }
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    // Continuous slider position float (0f .. 3f)
    val pillPosition = remember { Animatable(currentTabIndex.toFloat()) }
    var isTouched by remember { mutableStateOf(false) }
    var isDragging by remember { mutableStateOf(false) }
    var committedTab by remember { mutableIntStateOf(-1) }
    var lastHoveredTab by remember { mutableIntStateOf(currentTabIndex) }
    var dragSpeedTarget by remember { mutableFloatStateOf(0f) }

    // Coordinated flight origin and destination for seamless continuous scale envelope
    var flightOrigin by remember { mutableFloatStateOf(currentTabIndex.toFloat()) }
    var flightDestination by remember { mutableFloatStateOf(currentTabIndex.toFloat()) }

    LaunchedEffect(currentTabIndex) {
        isTouched = false
        isDragging = false
        dragSpeedTarget = 0f
        committedTab = -1
        lastHoveredTab = currentTabIndex
        if (flightDestination != currentTabIndex.toFloat() || !pillPosition.isRunning) {
            flightOrigin = pillPosition.value
            flightDestination = currentTabIndex.toFloat()
            pillPosition.animateTo(
                targetValue = currentTabIndex.toFloat(),
                animationSpec = spring(
                    dampingRatio = 0.84f,
                    stiffness = 440f
                )
            )
        }
    }

    // Touch scale: Expands to 1.34x when actively touched or dragged
    val isInteracting = isTouched || isDragging
    val touchScale by animateFloatAsState(
        targetValue = if (isInteracting) 1.34f else 1.0f,
        animationSpec = spring(dampingRatio = 0.80f, stiffness = 420f),
        label = "dock_touch_scale"
    )

    // Continuous transit flight scale (swells gently up to 1.20x ONLY while actively in-flight animation)
    val totalFlightDistance = abs(flightDestination - flightOrigin)
    val flightScale = if (!isInteracting && pillPosition.isRunning && totalFlightDistance > 0.05f) {
        val denom = flightDestination - flightOrigin
        val flightProgress = if (abs(denom) > 0.001f) {
            ((pillPosition.value - flightOrigin) / denom).coerceIn(0f, 1f)
        } else 1f
        1.0f + 0.20f * sin(Math.PI * flightProgress).toFloat()
    } else 1.0f

    val effectiveSliderScale = if (isInteracting) touchScale else maxOf(touchScale, flightScale)

    // Dynamic sliding velocity tracker for organic velocity-based stretch deformation
    val smoothedDragSpeed by animateFloatAsState(
        targetValue = dragSpeedTarget,
        animationSpec = spring(dampingRatio = 0.78f, stiffness = 550f),
        label = "dock_drag_speed"
    )

    // Velocity-driven stretch deformation:
    // Gentle, subtle horizontal stretch (max ~8%), with subtle vertical squash to preserve visual mass
    val stretchFactorX = 1.0f + 0.06f * smoothedDragSpeed.coerceIn(0f, 1.5f)
    val squashFactorY = 1.0f / sqrt(stretchFactorX)

    val finalSliderScaleX = effectiveSliderScale * stretchFactorX
    val finalSliderScaleY = effectiveSliderScale * squashFactorY

    // Sleek dark container color that cleanly separates from Tools and Profile card surfaces
    val dockContainerColor = Color(0xFF0F1218)

    // Main tab (Tab 0) dynamic shrink to create room for Start Ride Button on the right
    val isMainTab = (currentTabIndex == 0)
    val mainTabExtrasProgress by animateFloatAsState(
        targetValue = if (isMainTab) 1.0f else 0.0f,
        animationSpec = spring(
            dampingRatio = 0.84f,
            stiffness = 420f
        ),
        label = "dock_main_extras_progress"
    )

    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(horizontal = 20.dp, vertical = 14.dp)
    ) {
        val fullWidth = maxWidth

        // LAYER: Floating Locate Button, directly above the Tab 0 slider and horizontally aligned with it
        // Size: 52.dp circle (exact same as the dock slider pill height)
        if (mainTabExtrasProgress > 0.02f) {
            val locateBtnSize = 52.dp
            val locateBtnOffsetX = 6.dp

            var isLocPressed by remember { mutableStateOf(false) }
            val locScale by animateFloatAsState(
                targetValue = if (isLocPressed) 0.88f else 1.0f,
                animationSpec = spring(dampingRatio = 0.75f, stiffness = 520f),
                label = "loc_btn_press_scale"
            )

            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .offset(x = locateBtnOffsetX, y = (-76).dp)
                    .size(locateBtnSize)
                    .graphicsLayer {
                        val p = mainTabExtrasProgress
                        alpha = p.coerceIn(0f, 1f)
                        scaleX = p * locScale
                        scaleY = p * locScale
                        transformOrigin = TransformOrigin(0.5f, 0.5f)
                    }
                    .shadow(
                        elevation = 14.dp,
                        shape = CircleShape,
                        ambientColor = Color.Black.copy(alpha = 0.55f),
                        spotColor = Color.Black.copy(alpha = 0.65f)
                    )
                    .clip(CircleShape)
                    .background(dockContainerColor)
                    .border(1.2.dp, Color.White.copy(alpha = 0.08f), CircleShape)
                    .pointerInput(Unit) {
                        awaitEachGesture {
                            awaitFirstDown(requireUnconsumed = false)
                            isLocPressed = true
                            vibrateTick()
                            try {
                                val up = waitForUpOrCancellation()
                                if (up != null) {
                                    onLocationClick?.invoke()
                                }
                            } finally {
                                isLocPressed = false
                            }
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Rounded.MyLocation,
                    contentDescription = "定位当前位置",
                    tint = palette.accent,
                    modifier = Modifier.size(22.dp)
                )
            }
        }

        // Bottom Row: Dock Bar Base Pill + Right-side Start Ride Button
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Dock Bar Container (Height = 64.dp)
            // Automatically occupies remaining space (weight = 1f) so it smoothly shrinks to the left on Tab 0
            // and extends to full width when navigating to other tabs
            // CRITICAL: DO NOT apply .clip() here! This allows the enlarged slider to visibly exceed the 64.dp base!
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(64.dp),
                contentAlignment = Alignment.Center
            ) {
            // LAYER 1: Dock Bar Base Pill (Background, Shadow, and Border)
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
                    .background(dockContainerColor)
                    .border(1.2.dp, Color.White.copy(alpha = 0.08f), RoundedCornerShape(32.dp))
            )

            // LAYER 2: Unclipped Interactive Navigation Area
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .padding(horizontal = 6.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                val totalWidth = maxWidth
                val tabCount = tabs.size
                val tabWidth = totalWidth / tabCount
                val tabWidthPx = with(density) { tabWidth.toPx() }.coerceAtLeast(1f)
                val maxTabFloat = (tabCount - 1).toFloat()
                val touchSlopPx = with(density) { 12.dp.toPx() }

                fun lerpDp(start: androidx.compose.ui.unit.Dp, stop: androidx.compose.ui.unit.Dp, fraction: Float): androidx.compose.ui.unit.Dp {
                    return (start.value + (stop.value - start.value) * fraction.coerceIn(0f, 1f)).dp
                }

                // Dynamic smooth interpolation between Tab 0 circular slider and other tabs pill slider
                val p = mainTabExtrasProgress
                val widthAtTab0 = lerpDp(tabWidth - 8.dp, 52.dp, p)
                val leftAtTab0 = lerpDp(4.dp, 0.dp, p)
                val pos = pillPosition.value
                val t = pos.coerceIn(0f, 1f)
                val currentSliderWidth = lerpDp(widthAtTab0, tabWidth - 8.dp, t)
                val currentLeftOffsetDp = lerpDp(leftAtTab0, 4.dp, t) + with(density) { (pos * tabWidthPx).toDp() }

                // Active visual tab is cleanly tied to currentTabIndex (no mid-flight icon flashing!)
                val activeVisualTab = currentTabIndex.coerceIn(0, tabCount - 1)

                // LAYER 2A: Active Indicator Pill (with Velocity-Driven Dynamic Stretch)
                // Base height = 52.dp. When effectiveSliderScale = 1.40x, height is 72.8dp!
                // Stretches horizontally along movement axis proportional to swipe speed!
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .offset {
                            IntOffset(
                                x = with(density) { currentLeftOffsetDp.toPx() }.roundToInt(),
                                y = 0
                            )
                        }
                        .width(currentSliderWidth)
                        .height(52.dp)
                        .graphicsLayer {
                            scaleX = finalSliderScaleX
                            scaleY = finalSliderScaleY
                        }
                        .shadow(
                            elevation = if (effectiveSliderScale > 1.05f) 14.dp else 2.dp,
                            shape = RoundedCornerShape(26.dp),
                            ambientColor = palette.accent.copy(alpha = 0.50f),
                            spotColor = palette.accent.copy(alpha = 0.65f)
                        )
                        .clip(RoundedCornerShape(26.dp))
                        .background(palette.accent)
                )

                // LAYER 2B: Navigation Tab Icons Row
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    tabs.forEachIndexed { index, tab ->
                        val isCurrent = activeVisualTab == index

                        val iconScale by animateFloatAsState(
                            targetValue = if (isCurrent) 1.15f else 1.0f,
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioNoBouncy,
                                stiffness = Spring.StiffnessMedium
                            ),
                            label = "dock_tab_scale"
                        )
                        val iconColor by animateColorAsState(
                            targetValue = if (isCurrent) palette.onAccent else palette.secondaryText,
                            animationSpec = spring(stiffness = Spring.StiffnessMediumLow),
                            label = "dock_tab_color"
                        )

                        val iconOffsetXDp = if (index == 0) lerpDp(0.dp, 26.dp - tabWidth / 2, p) else 0.dp

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight(),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = tab.icon,
                                contentDescription = tab.title,
                                tint = iconColor,
                                modifier = Modifier
                                    .offset(x = iconOffsetXDp)
                                    .size(23.dp)
                                    .scale(iconScale)
                            )
                        }
                    }
                }

                // LAYER 2C: Full-Dock Interactive Touch & Drag Gesture Detector (handles tap, hold glide, and drag tracking)
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .pointerInput(tabWidthPx) {
                            awaitEachGesture {
                                val down = awaitFirstDown(requireUnconsumed = false)
                                isTouched = true
                                committedTab = -1
                                dragSpeedTarget = 0f
                                val downX = down.position.x
                                var prevDownX = downX
                                var prevDownTime = down.uptimeMillis
                                var lastX = downX

                                val startTabIndex = (downX / tabWidthPx).toInt().coerceIn(0, tabCount - 1)
                                lastHoveredTab = startTabIndex
                                vibrateTick()

                                // Immediately glide slider towards touched tab upon touch-down
                                if (abs(pillPosition.value - startTabIndex.toFloat()) > 0.08f) {
                                    flightOrigin = pillPosition.value
                                    flightDestination = startTabIndex.toFloat()
                                    scope.launch {
                                        pillPosition.animateTo(
                                            targetValue = startTabIndex.toFloat(),
                                            animationSpec = spring(
                                                dampingRatio = 0.84f,
                                                stiffness = 440f
                                            )
                                        )
                                    }
                                }

                                var isActuallyDragging = false

                                do {
                                    val event = awaitPointerEvent()
                                    val change = event.changes.firstOrNull { it.id == down.id } ?: break
                                    if (change.pressed) {
                                        val curX = change.position.x
                                        lastX = curX
                                        val curTime = change.uptimeMillis
                                        val dtMs = (curTime - prevDownTime).coerceAtLeast(1L)
                                        val dx = curX - prevDownX
                                        val instantVx = abs(dx) / dtMs.toFloat()
                                        val normSpeed = (instantVx * 1.2f).coerceIn(0f, 1.5f)

                                        prevDownX = curX
                                        prevDownTime = curTime

                                        val totalMoveDist = abs(curX - downX)
                                        if (!isActuallyDragging && totalMoveDist > touchSlopPx) {
                                            isActuallyDragging = true
                                            isDragging = true
                                        }

                                        if (isActuallyDragging) {
                                            dragSpeedTarget = normSpeed
                                            change.consume()
                                            val pillCenterFrac = ((curX - (tabWidthPx / 2f)) / tabWidthPx).coerceIn(0f, maxTabFloat)
                                            val h = (curX / tabWidthPx).toInt().coerceIn(0, tabCount - 1)
                                            if (h != lastHoveredTab) {
                                                lastHoveredTab = h
                                                vibrateTick()
                                            }
                                            scope.launch { pillPosition.snapTo(pillCenterFrac) }
                                        } else {
                                            dragSpeedTarget = dragSpeedTarget * 0.75f
                                        }
                                    }
                                } while (event.changes.any { it.pressed })

                                val wasDragging = isActuallyDragging
                                isTouched = false
                                isDragging = false
                                dragSpeedTarget = 0f

                                val finalTab = if (wasDragging) {
                                    (lastX / tabWidthPx).toInt().coerceIn(0, tabCount - 1)
                                } else {
                                    startTabIndex
                                }

                                committedTab = finalTab
                                lastHoveredTab = finalTab
                                vibrateTick()
                                if (flightDestination != finalTab.toFloat() || !pillPosition.isRunning) {
                                    flightOrigin = pillPosition.value
                                    flightDestination = finalTab.toFloat()
                                    scope.launch {
                                        pillPosition.animateTo(
                                            targetValue = finalTab.toFloat(),
                                            animationSpec = spring(
                                                dampingRatio = 0.88f,
                                                stiffness = 520f
                                            )
                                        )
                                    }
                                }
                                onTabSelected(finalTab)
                            }
                        }
                )
            }
        }

            // Right-side Start Ride Button (Smoothly expands in the space freed on Tab 0)
            if (mainTabExtrasProgress > 0.005f) {
                val btnBaseSize = 64.dp
                val dynamicSpacing = 10.dp * mainTabExtrasProgress
                Spacer(modifier = Modifier.width(dynamicSpacing))

                Box(
                    modifier = Modifier
                        .width(btnBaseSize * mainTabExtrasProgress)
                        .height(btnBaseSize),
                    contentAlignment = Alignment.Center
                ) {
                    if (mainTabExtrasProgress > 0.10f) {
                        var isStartPressed by remember { mutableStateOf(false) }
                        val startScale by animateFloatAsState(
                            targetValue = if (isStartPressed) 0.88f else 1.0f,
                            animationSpec = spring(dampingRatio = 0.75f, stiffness = 520f),
                            label = "start_btn_press_scale"
                        )

                        Box(
                            modifier = Modifier
                                .size(btnBaseSize)
                                .graphicsLayer {
                                    val p = mainTabExtrasProgress
                                    alpha = p.coerceIn(0f, 1f)
                                    scaleX = p * startScale
                                    scaleY = p * startScale
                                    transformOrigin = TransformOrigin(0.5f, 0.5f)
                                }
                                .shadow(
                                    elevation = 16.dp,
                                    shape = CircleShape,
                                    ambientColor = palette.accent.copy(alpha = 0.40f),
                                    spotColor = palette.accent.copy(alpha = 0.55f)
                                )
                                .clip(CircleShape)
                                .background(palette.accent)
                                .border(1.2.dp, Color.White.copy(alpha = 0.12f), CircleShape)
                                .pointerInput(Unit) {
                                    awaitEachGesture {
                                        awaitFirstDown(requireUnconsumed = false)
                                        isStartPressed = true
                                        vibrateTick()
                                        try {
                                            val up = waitForUpOrCancellation()
                                            if (up != null) {
                                                onStartRideClick?.invoke()
                                            }
                                        } finally {
                                            isStartPressed = false
                                        }
                                    }
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Rounded.DirectionsBike,
                                contentDescription = "开始骑行",
                                tint = palette.onAccent,
                                modifier = Modifier.size(28.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
