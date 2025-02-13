package com.ai.integrator.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material.icons.outlined.MusicNote
import androidx.compose.material.icons.outlined.Videocam
import androidx.compose.material.icons.rounded.ChatBubble
import androidx.compose.material.icons.rounded.Image
import androidx.compose.material.icons.rounded.MusicNote
import androidx.compose.material.icons.rounded.Videocam
import androidx.compose.ui.graphics.vector.ImageVector
import com.ai.integrator.R

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    @StringRes val iconTextId: Int,
) {
    DIALOGUE(
        selectedIcon = Icons.Rounded.ChatBubble,
        unselectedIcon = Icons.Outlined.ChatBubbleOutline,
        iconTextId = R.string.app_nav_bottom_bar_item_dialogue,
    ),
    IMAGE(
        selectedIcon = Icons.Rounded.Image,
        unselectedIcon = Icons.Outlined.Image,
        iconTextId = R.string.app_nav_bottom_bar_item_image,
    ),
    MUSIC(
        selectedIcon = Icons.Rounded.MusicNote,
        unselectedIcon = Icons.Outlined.MusicNote,
        iconTextId = R.string.app_nav_bottom_bar_item_music,
    ),
    VIDEO(
        selectedIcon = Icons.Rounded.Videocam,
        unselectedIcon = Icons.Outlined.Videocam,
        iconTextId = R.string.app_nav_bottom_bar_item_video,
    ),
}