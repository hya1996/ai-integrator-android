package com.ai.integrator

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
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
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Scaffold(
            bottomBar = {
                AINavBottomBar()
            },
        ) { padding ->
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