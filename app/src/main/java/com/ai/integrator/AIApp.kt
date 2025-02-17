package com.ai.integrator

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ai.integrator.component.bottombar.AINavBottomBar
import com.ai.integrator.core.ui.theme.AITheme
import com.ai.integrator.feature.dialogue.screen.home.DialogueHomeScreen

@Composable
fun AIApp(
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier
            .fillMaxSize(),
        color = colorScheme.primaryContainer,
    ) {
        Scaffold(
            modifier = Modifier
                .windowInsetsPadding(WindowInsets.safeDrawing),
            bottomBar = {
                AINavBottomBar()
            },
        ) { _ ->
            DialogueHomeScreen()
        }
    }
}

@Preview
@Composable
fun AIAppPreview() {
    AITheme {
        AIApp()
    }
}