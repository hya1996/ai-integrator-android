package com.ai.integrator

import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ai.integrator.component.bottombar.AINavBottomBar
import com.ai.integrator.core.ui.theme.AITheme

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
            Text(
                text = "Hello World!",
                modifier = modifier.consumeWindowInsets(padding)
            )
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