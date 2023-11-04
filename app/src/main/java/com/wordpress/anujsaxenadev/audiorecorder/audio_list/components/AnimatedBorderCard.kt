package com.wordpress.anujsaxenadev.audiorecorder.audio_list.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import com.wordpress.anujsaxenadev.ui.theme.Dimen_4adp

@Composable
inline fun AnimatedBorderCard(
    modifier: Modifier,
    shape: RoundedCornerShape,
    crossinline content: @Composable () -> Unit
){
    val duration = 10000
    val infiniteTransition = rememberInfiniteTransition("AnimatedBorderCardAnimation")
    val degrees = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = duration, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = ""
    ).value

    Surface(
        modifier = modifier,
        shape = shape
    ) {
        Surface(modifier = Modifier
            .padding(Dimen_4adp)
            .drawWithContent {
                rotate(degrees = degrees) {
                    drawCircle(
                        brush = Brush.linearGradient(listOf(Color.Magenta, Color.Cyan)),
                        radius = size.width,
                        blendMode = BlendMode.SrcIn
                    )
                }
                drawContent()
            }) {
            content()
        }
    }
}