package com.ai.integrator.feature.dialogue.screen.detail.component.messagelist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun DialogueDetailMessageList(
    content: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .background(
                color = colorScheme.primaryContainer
            ),
    ) {
        Text(
            text = content,
            color = colorScheme.primary,
            fontSize = 16.sp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}