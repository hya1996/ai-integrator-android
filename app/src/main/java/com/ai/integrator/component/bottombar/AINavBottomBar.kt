package com.ai.integrator.component.bottombar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ai.integrator.core.ui.theme.AITheme

@Composable
fun AINavBottomBar(
    modifier: Modifier = Modifier,
    viewModel: AINavViewModel = AINavViewModel(),
) {
    val destinations by viewModel.destinations.collectAsStateWithLifecycle()
    val selectedDest by viewModel.selectedDest.collectAsStateWithLifecycle()

    Column {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.5.dp)
                .background(colorScheme.outline)
        )
        NavigationBar(
            modifier = modifier,
            containerColor = colorScheme.background,
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
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.Black,
            indicatorColor = Color.Transparent,
        )
    )
}

@Preview
@Composable
fun AINavBottomBarPreview() {
    AITheme {
        AINavBottomBar()
    }
}