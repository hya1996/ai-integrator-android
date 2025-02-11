package com.ai.integrator.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

val defaultLightColorScheme = lightColorScheme()

val defaultDarkColorScheme = darkColorScheme()

@Composable
fun AITheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) defaultDarkColorScheme else defaultLightColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}