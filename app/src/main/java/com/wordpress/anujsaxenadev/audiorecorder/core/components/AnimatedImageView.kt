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
        private val DefaultAnimationIteration: AnimationIteration = AnimationIteration.Forever
        private const val DefaultIsPlaying: Boolean = true

        @Composable
        fun AnimatedImage(
            id: Int,
            modifier: Modifier? = DefaultModifier,
            contentScale: ContentScale? = DefaultContentScale,
            iterations: AnimationIteration? = DefaultAnimationIteration,
            isPlaying: Boolean? = DefaultIsPlaying,
            progress: (() -> Float)? = null
        ) {
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(id))
            if(progress != null){
                LottieAnimation(
                    composition = composition,
                    progress = progress,
                    modifier = modifier ?: DefaultModifier,
                    contentScale = contentScale ?: DefaultContentScale
                )
            }
            else {
                LottieAnimation(
                    composition = composition,
                    modifier = modifier ?: DefaultModifier,
                    contentScale = contentScale ?: DefaultContentScale,
                    iterations = getAnimationIterationType(iterations ?: DefaultAnimationIteration),
                    restartOnPlay = false,
                    isPlaying = isPlaying ?: DefaultIsPlaying
                )
            }
        }


        private fun getAnimationIterationType(iterations: AnimationIteration): Int{
            return when(iterations){
                AnimationIteration.Forever -> LottieConstants.IterateForever
                AnimationIteration.OneTime -> 1
            }
        }
    }
}

sealed interface AnimationIteration{
    object OneTime: AnimationIteration
    object Forever: AnimationIteration
}