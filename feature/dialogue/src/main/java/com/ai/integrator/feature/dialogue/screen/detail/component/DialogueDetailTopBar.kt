package com.ai.integrator.feature.dialogue.screen.detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ai.integrator.core.ui.theme.AITheme

@Composable
fun DialogueDetailTopBar(
    title: String,
    subtitle: String = "",
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .height(44.dp),
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = colorScheme.primary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Text(
            text = subtitle,
            fontSize = 13.sp,
            color = colorScheme.secondary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview
@Composable
fun DialogueDetailTopBar() {
    AITheme {
        DialogueDetailTopBar(
            title = "DeepSeek",
            subtitle = "DeepSeek-R1-Distill-Llama-8B",
        )
    }
}