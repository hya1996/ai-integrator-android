package com.ai.integrator.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.ai.integrator.feature.dialogue.navigation.DialogueRoute
import com.ai.integrator.feature.dialogue.navigation.dialogueNavGraph
import com.ai.integrator.feature.dialogue.navigation.navigateToDialogueDetail

@Composable
fun AINavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = DialogueRoute,
        modifier = modifier,
    ) {
        dialogueNavGraph(
            onModelItemClick = { modelInfo ->
                navController.navigateToDialogueDetail(modelInfo)
            },
            onBackClick = {
                navController.popBackStack()
            }
        )
    }
}