package com.ai.integrator.component.bottombar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ai.integrator.core.ui.theme.AITheme

@Composable
fun AINavBottomBar(
    modifier: Modifier = Modifier,
    viewModel: AINavViewModel = AINavViewModel(),
) {
    val destinations by viewModel.destinations.collectAsStateWithLifecycle()
    val selectedDest by viewModel.selectedDest.collectAsStateWithLifecycle()

    NavigationBar(
        modifier = modifier,
        content = {
            destinations.forEach { dest ->
                val iconText = stringResource(dest.iconTextId)
                AINavBottomBarItem(
                    selected = dest == selectedDest,
                    onClick = { viewModel.selectDest(dest) },
                    iconText = iconText,
                    icon = {
                        Icon(
                            imageVector = dest.unselectedIcon,
                            contentDescription = iconText,
                        )
                    },
                    selectedIcon = {
                        Icon(
                            imageVector = dest.selectedIcon,
                            contentDescription = iconText,
                        )
                    }
                )
            }
        },
    )
}

@Composable
fun RowScope.AINavBottomBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconText: String,
    icon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit = icon,
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = if (selected) selectedIcon else icon,
        label = {
            Text(text = iconText)
        },
        modifier = modifier,
    )
}

@Preview
@Composable
fun AINavBottomBarPreview() {
    AITheme {
        AINavBottomBar()
    }
}