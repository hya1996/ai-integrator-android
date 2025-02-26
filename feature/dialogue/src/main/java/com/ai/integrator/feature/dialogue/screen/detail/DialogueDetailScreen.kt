package com.ai.integrator.feature.dialogue.screen.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ai.integrator.core.ui.ime.rememberImeVisibility
import com.ai.integrator.data.dialogue.model.DialogueModelInfo
import com.ai.integrator.feature.dialogue.screen.detail.component.bottombar.DialogueDetailBottomBar
import com.ai.integrator.feature.dialogue.screen.detail.component.messagelist.DialogueDetailMessageList
import com.ai.integrator.feature.dialogue.screen.detail.component.topbar.DialogueDetailTopBar

@Composable
fun DialogueDetailScreen(
    modelInfo: DialogueModelInfo,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DialogueDetailViewModel = viewModel()
) {
    val localFocusManger = LocalFocusManager.current

    val inputContent by viewModel.inputContent.collectAsStateWithLifecycle()
    val enableSend by viewModel.enableSend.collectAsStateWithLifecycle()

    val isImeVisible by rememberImeVisibility()

    Column(
        modifier = modifier
            .fillMaxHeight()
            .background(colorScheme.primaryContainer),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier.weight(1f),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                DialogueDetailTopBar(
                    title = modelInfo.name,
                    subtitle = modelInfo.intro,
                    onBackClick = onBackClick,
                )
                DialogueDetailMessageList(
                    modifier = Modifier
                        .weight(1f),
                )
            }
            if (isImeVisible) {
                Spacer(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .background(color = Color.Transparent)
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onPress = {
                                    localFocusManger.clearFocus()
                                }
                            )
                        }
                )
            }
        }
        DialogueDetailBottomBar(
            inputContent = inputContent,
            onInputChange = { viewModel.updateInputContent(it) },
            enableSend = enableSend,
            onSendClick = {},
        )
    }
}