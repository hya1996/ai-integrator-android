package com.ai.integrator.feature.dialogue.screen.home

import com.ai.integrator.core.framework.viewmodel.BaseViewModel
import com.ai.integrator.data.dialogue.model.DialogueModelInfo
import com.ai.integrator.feature.dialogue.screen.home.component.modellist.DialogueHomeModelItemData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DialogueHomeViewModel : BaseViewModel() {
    private val _modelList = MutableStateFlow<List<DialogueHomeModelItemData>>(emptyList())
    val modelList = _modelList.asStateFlow()

    init {
        _modelList.value = listOf(
            DialogueHomeModelItemData(
                modelInfo = DialogueModelInfo(
                    name = "DeepSeek",
                    iconUrl = "https://play-lh.googleusercontent.com/d2zqBFBEymSZKaVg_dRo1gh3hBFn7_Kl9rO74xkDmnJeLgDW0MoJD3cUx0QzZN6jdsg=w480-h960-rw",
                    intro = "DeepSeek-R1-Distill-Llama-8B",
                )
            )
        )
    }
}