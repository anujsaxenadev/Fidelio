package com.wordpress.anujsaxenadev.audiorecorder.core.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

class AnimatedImageView{
    companion object{
        private val DefaultContentScale: ContentScale = ContentScale.Crop
        private val DefaultModifier: Modifier = Modifier.aspectRatio(1f)

        @Composable
        fun getAnimatedImage(
            id: Int,
            contentScale: ContentScale? = DefaultContentScale,
            modifier: Modifier? = DefaultModifier
        ) {
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(id))
            LottieAnimation(
                composition = composition,
                modifier = modifier ?: DefaultModifier,
                contentScale = contentScale ?: DefaultContentScale,
                iterations = LottieConstants.IterateForever
            )
        }
    }
}