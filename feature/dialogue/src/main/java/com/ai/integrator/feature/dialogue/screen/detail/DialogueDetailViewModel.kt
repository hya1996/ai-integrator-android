package com.ai.integrator.feature.dialogue.screen.detail

import androidx.lifecycle.viewModelScope
import com.ai.integrator.core.framework.flow.asState
import com.ai.integrator.core.framework.viewmodel.BaseViewModel
import com.ai.integrator.data.dialogue.model.DIALOGUE_ROLE_USER
import com.ai.integrator.data.dialogue.model.DialogueMessage
import com.ai.integrator.data.dialogue.model.DialogueModelInfo
import com.ai.integrator.data.dialogue.repository.DialogueDetailRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class DialogueDetailViewModel : BaseViewModel() {
    private val _inputContent = MutableStateFlow("")
    val inputContent = _inputContent.asStateFlow()

    val enableSend: StateFlow<Boolean> = inputContent
        .map { it.isNotEmpty() }
        .asState(viewModelScope, false)

    private val _reply = MutableStateFlow("")
    val reply = _reply.asStateFlow()

    private val dialogueDetailRepo = DialogueDetailRepository()
    private var modelInfo: DialogueModelInfo? = null

    fun init(modelInfo: DialogueModelInfo) {
        this.modelInfo = modelInfo
    }

    fun updateInputContent(content: String) {
        _inputContent.value = content
    }

    fun sendDialogueMessage() = viewModelScope.launch(Dispatchers.IO) {
        val modelInfo = modelInfo ?: return@launch
        val message = DialogueMessage(
            role = DIALOGUE_ROLE_USER,
            content = _inputContent.value
        )
        val resp = dialogueDetailRepo.reqDialogueReply(modelInfo.modelName, listOf(message))
        _reply.value = "resp: $resp"
    }
}