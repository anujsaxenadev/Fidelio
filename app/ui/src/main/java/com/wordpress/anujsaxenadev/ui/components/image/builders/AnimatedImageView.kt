package com.wordpress.anujsaxenadev.ui.components.image.builders

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.wordpress.anujsaxenadev.ui.components.image.ImageType

class AnimatedJsonBuilder : ImageBuilder<ImageType.AnimatedJson> {
    @Composable
    override fun build(imageType: ImageType.AnimatedJson) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(imageType.id))
        if(imageType.progress != null){
            LottieAnimation(
                composition = composition,
                progress = imageType.progress,
                modifier = imageType.modifier ?: Modifier,
                contentScale = imageType.contentScale ?: ImageType.DefaultImageContentScale
            )
        }
        else {
            LottieAnimation(
                composition = composition,
                modifier = imageType.modifier ?: Modifier,
                contentScale = imageType.contentScale ?: ImageType.DefaultImageContentScale,
                iterations = getAnimationIterationType(
                    imageType.iterations ?: AnimationIteration.Forever
                ),
                restartOnPlay = false,
                isPlaying = imageType.isPlaying ?: true
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

sealed interface AnimationIteration{
    data object OneTime: AnimationIteration
    data object Forever: AnimationIteration
}
