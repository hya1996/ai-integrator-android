package com.ai.integrator.data.dialogue.datasource

import com.ai.integrator.data.dialogue.model.DialogueModelInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class DialogueModelLocalDataSource {
    fun getModelList(): Flow<List<DialogueModelInfo>> {
        return flowOf(
            listOf(
                DialogueModelInfo(
                    simpleName = "DeepSeek",
                    modelName = "deepseek-ai/DeepSeek-R1-Distill-Qwen-7B",
                    iconUrl = "https://play-lh.googleusercontent.com/d2zqBFBEymSZKaVg_dRo1gh3hBFn7_Kl9rO74xkDmnJeLgDW0MoJD3cUx0QzZN6jdsg=w480-h960-rw",
                    intro = "DeepSeek-R1-Distill-Qwen-7B",
                ),
                DialogueModelInfo(
                    simpleName = "Qwen",
                    modelName = "Qwen/Qwen2.5-7B-Instruct",
                    iconUrl = "https://www.buzzwoo.de/wp-content/uploads/2024/06/qwen-logo.png",
                    intro = "Qwen2.5-7B-Instruct",
                )
            )
        )
    }
}