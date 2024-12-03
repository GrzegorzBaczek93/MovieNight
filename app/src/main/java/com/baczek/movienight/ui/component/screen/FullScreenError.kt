package com.baczek.movienight.ui.component.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.baczek.movienight.ui.component.VerticalSpacer

@Composable
fun FullScreenError(
    text: String,
    buttonText: String,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(text = text)
            VerticalSpacer(48.dp)
            FilledTonalButton(
                onClick = onClick
            ) {
                Text(text = buttonText)
            }
        }
    }
}