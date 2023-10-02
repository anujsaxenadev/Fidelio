package com.wordpress.anujsaxenadev.audiorecorder.player.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun AudioDescription(
    title: String,
    name: String
) {
    Text(
        text = title,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        color = Color.White,
        fontWeight = FontWeight.Bold
    )
}