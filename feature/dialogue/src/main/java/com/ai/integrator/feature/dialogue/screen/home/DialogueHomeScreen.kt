package com.ai.integrator.feature.dialogue.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ai.integrator.feature.dialogue.screen.home.component.topbar.DialogueHomeTopBar

@Composable
fun DialogueHomeScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        DialogueHomeTopBar()
    }
}