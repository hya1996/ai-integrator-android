package com.ai.integrator.feature.dialogue.screen.home.component.modellist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.ai.integrator.data.dialogue.model.DialogueModelInfo

data class DialogueHomeModelItemData(
    val modelInfo: DialogueModelInfo,
)

@Composable
fun DialogueHomeModeItem(
    itemData: DialogueHomeModelItemData,
    modifier: Modifier = Modifier,
) {
    val modelInfo = itemData.modelInfo
    Row(
        modifier = modifier
            .height(76.dp)
            .fillMaxWidth()
            .background(colorScheme.primaryContainer)
            .padding(start = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            model = modelInfo.iconUrl,
            contentDescription = null,
            modifier = Modifier
                .size(52.dp, 52.dp)
                .clip(CircleShape),
        )
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 12.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.height(75.dp)
            ) {
                Text(
                    text = modelInfo.name,
                    color = colorScheme.primary,
                    fontSize = 16.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(end = 16.dp),
                )
                Text(
                    text = modelInfo.intro,
                    color = colorScheme.secondary,
                    fontSize = 13.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(end = 16.dp),
                )
            }
            HorizontalDivider(
                thickness = 1.dp,
                color = colorScheme.outline,
            )
        }
    }
}