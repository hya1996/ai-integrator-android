package com.ai.integrator.feature.dialogue.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ai.integrator.feature.dialogue.screen.home.component.modellist.DialogueHomeModelList
import com.ai.integrator.feature.dialogue.screen.home.component.topbar.DialogueHomeTopBar

@Composable
fun DialogueHomeScreen(
    modifier: Modifier = Modifier,
    viewModel: DialogueHomeViewModel = DialogueHomeViewModel(),
) {
    val modelList by viewModel.modelList.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxHeight()
            .background(colorScheme.primaryContainer)
    ) {
        DialogueHomeTopBar()
        DialogueHomeModelList(
            modelList = modelList
        )
    }
}