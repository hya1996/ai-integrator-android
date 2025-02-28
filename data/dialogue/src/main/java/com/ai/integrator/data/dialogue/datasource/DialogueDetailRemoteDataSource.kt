package com.ai.integrator.data.dialogue.datasource

import com.ai.integrator.data.dialogue.model.DialogueMessage
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

private data class ResponseFormat(
    val type: String
)

private data class DialogueReplyReqBody(
    val model: String,
    val messages: List<DialogueMessage>,
    val stream: Boolean = false,
    val tools: List<Any> = emptyList(),
    val responseFormat: ResponseFormat = ResponseFormat(type = "text"),
    val stop: String? = null,
)

private interface DialogueDetailServiceApi {
    @Headers(
        "Authorization: Bearer sk-vtiqeykowtykmbbezoczihtlxkoixbyukpxgsrybspqytyrt",
        "Content-Type: application/json"
    )
    @POST("chat/completions")
    suspend fun reqDialogueReply(
        @Body reqBody: DialogueReplyReqBody
    ): Any
}

class DialogueDetailRemoteDataSource {
    private val serviceApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DialogueDetailServiceApi::class.java)
    }

    suspend fun reqDialogueReply(
        modelName: String,
        messages: List<DialogueMessage>
    ): Any {
        val reqBody = DialogueReplyReqBody(
            model = modelName,
            messages = messages
        )
        return serviceApi.reqDialogueReply(reqBody)
    }

    companion object {
        private const val BASE_URL = "https://api.siliconflow.cn/v1/"
    }
}