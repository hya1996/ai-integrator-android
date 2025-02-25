package com.ai.integrator.feature.dialogue.screen.home.component.topbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ai.integrator.feature.dialogue.R
import com.ai.integrator.core.ui.theme.AITheme

@Composable
fun DialogueHomeTopBar(
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(colorScheme.primaryContainer),
    ) {
        Text(
            text = stringResource(R.string.feature_dialogue_home_title),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = colorScheme.primary
        )
    }
}

@Preview
@Composable
fun DialogueHomeTopBarPreview() {
    AITheme {
        DialogueHomeTopBar()
    }
}