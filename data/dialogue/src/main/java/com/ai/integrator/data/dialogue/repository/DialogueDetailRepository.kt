package com.ai.integrator.data.dialogue.repository

import com.ai.integrator.data.dialogue.datasource.DialogueDetailRemoteDataSource
import com.ai.integrator.data.dialogue.model.DialogueMessage

class DialogueDetailRepository(
    private val dialogueDetailRemoteDS: DialogueDetailRemoteDataSource = DialogueDetailRemoteDataSource(),
) {
    suspend fun reqDialogueReply(
        modelName: String,
        messages: List<DialogueMessage>
    ): Any = dialogueDetailRemoteDS.reqDialogueReply(modelName, messages)
}