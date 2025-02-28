package com.ai.integrator.data.dialogue.repository

import com.ai.integrator.data.dialogue.datasource.DialogueModelLocalDataSource
import com.ai.integrator.data.dialogue.model.DialogueModelInfo
import kotlinx.coroutines.flow.Flow

class DialogueModelRepository(
    private val dialogueModelLocalDS: DialogueModelLocalDataSource = DialogueModelLocalDataSource()
) {
    fun getModelList(): Flow<List<DialogueModelInfo>> = dialogueModelLocalDS.getModelList()
}