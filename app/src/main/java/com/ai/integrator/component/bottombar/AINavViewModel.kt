package com.ai.integrator.component.bottombar

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
import com.ai.integrator.core.framework.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

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

class AINavViewModel : BaseViewModel() {
    val destinations = MutableStateFlow(TopLevelDestination.entries).asStateFlow()

    private val _selectedDest = MutableStateFlow(TopLevelDestination.DIALOGUE)
    val selectedDest = _selectedDest.asStateFlow()

    fun selectDest(dest: TopLevelDestination) {
        _selectedDest.value = dest
    }
}