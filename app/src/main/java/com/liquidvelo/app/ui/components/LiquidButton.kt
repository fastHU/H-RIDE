package com.liquidvelo.app.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.liquidvelo.app.theme.LocalThemePalette
import com.liquidvelo.app.theme.liquidGlass
import com.liquidvelo.app.theme.liquidInteractiveButton

@Composable
fun LiquidButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(26.dp),
    backgroundColor: Color? = null,
    borderHighlightColor: Color? = null,
    contentPadding: PaddingValues = PaddingValues(horizontal = 28.dp, vertical = 16.dp),
    content: @Composable RowScope.() -> Unit
) {
    val palette = LocalThemePalette.current
    val bg = backgroundColor ?: palette.accent
    val border = borderHighlightColor ?: Color.White.copy(alpha = 0.35f)

    Box(
        modifier = modifier
            .liquidInteractiveButton(onClick = onClick, shape = shape)
            .liquidGlass(
                shape = shape,
                backgroundColor = bg,
                borderHighlightColor = border,
                elevation = 14.dp
            )
            .padding(contentPadding),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            content = content
        )
    }
}

@Composable
fun LiquidGlassPill(
    text: String,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    backgroundColor: Color? = null,
    textColor: Color? = null
) {
    val palette = LocalThemePalette.current
    val bg = backgroundColor ?: palette.surface.copy(alpha = 0.70f)
    val tc = textColor ?: palette.primaryText

    Box(
        modifier = modifier
            .liquidInteractiveButton(onClick = onClick, shape = RoundedCornerShape(18.dp))
            .liquidGlass(
                shape = RoundedCornerShape(18.dp),
                backgroundColor = bg,
                borderHighlightColor = Color.White.copy(alpha = 0.22f),
                elevation = 6.dp
            )
            .padding(horizontal = 14.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = tc
        )
    }
}
