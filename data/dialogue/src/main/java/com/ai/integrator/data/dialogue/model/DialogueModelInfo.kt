package com.ai.integrator.data.dialogue.model

import kotlinx.serialization.Serializable

@Serializable
data class DialogueModelInfo(
    val name: String,
    val iconUrl: String,
    val intro: String = "",
)
