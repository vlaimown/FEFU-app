package com.example.fefufirstproject.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = mainColor,
    surface = background,
    onSurface = boldTextColor,
    background = background,
    secondary = boldTextColor,
    tertiary = hintColor
)

@Composable
fun FEFUAppTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
