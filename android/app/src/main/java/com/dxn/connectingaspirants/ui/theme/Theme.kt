package com.dxn.connectingaspirants.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Color.White.copy(0.7f),
    onPrimary = Color.Black,
    onBackground = Color.White.copy(0.7f),
    primaryVariant = Color.White.copy(0.4f),
)

private val LightColorPalette = lightColors(
    primary = Color(0xFF20004f),
    onPrimary = Color.White,
    primaryVariant = Color.Black.copy(0.4f),
)

@Composable
fun ConnectingAspirantsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}