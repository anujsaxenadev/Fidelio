package com.wordpress.anujsaxenadev.audiorecorder.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.wordpress.anujsaxenadev.audiorecorder.ui.theme.DSGradientEnd
import com.wordpress.anujsaxenadev.audiorecorder.ui.theme.DSGradientStart

@Composable
inline fun GradientBackgroundComponent(content: @Composable (BoxScope.() -> Unit)) {
    Box(modifier = Modifier
        .background(
            brush = Brush.linearGradient(
                colors = listOf(
                    DSGradientEnd,
                    DSGradientStart
                )
            )
        ),
        content =  content
    )
}