package com.liquidvelo.app.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

val LocalThemePalette = compositionLocalOf { ThemeManager.getActivePalette() }

@Composable
fun LiquidVeloTheme(
    content: @Composable () -> Unit
) {
    val palette = ThemeManager.getActivePalette()
    val view = LocalView.current

    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            // True Edge-to-Edge full screen covering navigation bar and status bar
            WindowCompat.setDecorFitsSystemWindows(window, false)
            window.statusBarColor = android.graphics.Color.TRANSPARENT
            window.navigationBarColor = android.graphics.Color.TRANSPARENT
            val insetsController = WindowCompat.getInsetsController(window, view)
            insetsController.isAppearanceLightStatusBars = false
            insetsController.isAppearanceLightNavigationBars = false
        }
    }

    val darkScheme = darkColorScheme(
        primary = palette.accent,
        onPrimary = palette.onAccent,
        secondaryContainer = palette.surfaceContainerHigh,
        onSecondaryContainer = palette.primaryText,
        background = palette.background,
        surface = palette.surface,
        surfaceVariant = palette.surfaceContainer,
        onBackground = palette.primaryText,
        onSurface = palette.primaryText,
        onSurfaceVariant = palette.secondaryText
    )

    CompositionLocalProvider(LocalThemePalette provides palette) {
        MaterialTheme(
            colorScheme = darkScheme,
            typography = AppTypography,
            content = content
        )
    }
}
