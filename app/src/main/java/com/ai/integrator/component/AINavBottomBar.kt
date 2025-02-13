package com.ai.integrator.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ai.integrator.core.ui.theme.AITheme
import com.ai.integrator.navigation.TopLevelDestination

@Composable
fun AINavBottomBar(
    destinations: List<TopLevelDestination>,
    modifier: Modifier = Modifier,
) {
    NavigationBar(
        modifier = modifier,
        content = {
            destinations.forEachIndexed { index, item ->
                val iconText = stringResource(item.iconTextId)
                AINavBottomBarItem(
                    selected = index == 0,
                    onClick = {},
                    iconText = iconText,
                    icon = {
                        Icon(
                            imageVector = item.unselectedIcon,
                            contentDescription = iconText,
                        )
                    },
                    selectedIcon = {
                        Icon(
                            imageVector = item.selectedIcon,
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
        AINavBottomBar(destinations = TopLevelDestination.entries)
    }
}