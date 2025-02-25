package com.ai.integrator.feature.dialogue.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.ai.integrator.core.ui.navigation.serializableType
import com.ai.integrator.data.dialogue.model.DialogueModelInfo
import com.ai.integrator.feature.dialogue.screen.detail.DialogueDetailScreen
import com.ai.integrator.feature.dialogue.screen.home.DialogueHomeScreen
import kotlinx.serialization.Serializable
import kotlin.reflect.typeOf

@Serializable
data object DialogueRoute

@Serializable
data object DialogueHomeRoute

@Serializable
data class DialogueDetailRoute(
    val modelInfo: DialogueModelInfo,
)

fun NavController.navigateToDialogueHome() {
    navigate(route = DialogueHomeRoute)
}

fun NavController.navigateToDialogueDetail(modelInfo: DialogueModelInfo) {
    navigate(route = DialogueDetailRoute(modelInfo))
}

fun NavGraphBuilder.dialogueNavGraph(
    onModelItemClick: (DialogueModelInfo) -> Unit,
    onBackClick: () -> Unit,
) {
    navigation<DialogueRoute>(startDestination = DialogueHomeRoute) {
        composable<DialogueHomeRoute> {
            DialogueHomeScreen(
                onModelItemClick = onModelItemClick
            )
        }
        composable<DialogueDetailRoute>(
            typeMap = mapOf(typeOf<DialogueModelInfo>() to serializableType<DialogueModelInfo>()),
        ) {
            val route: DialogueDetailRoute = it.toRoute()
            DialogueDetailScreen(
                modelInfo = route.modelInfo,
                onBackClick = onBackClick,
            )
        }
    }
}