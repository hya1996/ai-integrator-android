package com.ai.integrator

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ai.integrator.component.bottombar.AINavBottomBar
import com.ai.integrator.core.ui.theme.AITheme
import com.ai.integrator.feature.dialogue.navigation.DialogueHomeRoute
import com.ai.integrator.navigation.AINavHost

@Composable
fun AIApp(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var showBottomBar by rememberSaveable { mutableStateOf(true) }

    val curRoute = navBackStackEntry?.destination
    when {
        curRoute == null -> {
            showBottomBar = true
        }
        curRoute.hasRoute(DialogueHomeRoute::class) -> {
            showBottomBar = true
        }
        else -> {
            showBottomBar = false
        }
    }

    Surface(
        modifier = modifier
            .fillMaxSize(),
        color = colorScheme.primaryContainer,
    ) {
        Scaffold(
            modifier = Modifier
                .windowInsetsPadding(WindowInsets.safeDrawing),
            bottomBar = {
                if (showBottomBar) {
                    AINavBottomBar()
                }
            },
        ) { paddingValues ->
            AINavHost(
                navController = navController,
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}

@Preview
@Composable
fun AIAppPreview() {
    AITheme {
        AIApp()
    }
}