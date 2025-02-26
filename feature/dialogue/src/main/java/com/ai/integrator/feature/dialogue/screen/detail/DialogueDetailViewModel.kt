package com.ai.integrator.feature.dialogue.screen.detail

import androidx.lifecycle.viewModelScope
import com.ai.integrator.core.framework.flow.asState
import com.ai.integrator.core.framework.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map

class DialogueDetailViewModel : BaseViewModel() {
    private val _inputContent = MutableStateFlow("")
    val inputContent = _inputContent.asStateFlow()

    val enableSend: StateFlow<Boolean> = inputContent
        .map { it.isNotEmpty() }
        .asState(viewModelScope, false)

    fun updateInputContent(content: String) {
        _inputContent.value = content
    }
}