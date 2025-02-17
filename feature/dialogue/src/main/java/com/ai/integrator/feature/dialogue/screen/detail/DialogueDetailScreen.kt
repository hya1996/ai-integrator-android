package com.ai.integrator.feature.dialogue.screen.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ai.integrator.data.dialogue.model.DialogueModelInfo
import com.ai.integrator.feature.dialogue.screen.detail.component.DialogueDetailTopBar

@Composable
fun DialogueDetailScreen(
    modelInfo: DialogueModelInfo,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .background(colorScheme.primaryContainer),
    ) {
        DialogueDetailTopBar(
            title = modelInfo.name,
            subtitle = modelInfo.intro,
        )
    }
}