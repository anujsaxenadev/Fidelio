package com.wordpress.anujsaxenadev.ui.components.image

import androidx.compose.runtime.Composable
import com.wordpress.anujsaxenadev.ui.components.image.builders.AnimatedJsonBuilder
import com.wordpress.anujsaxenadev.ui.components.image.builders.ResourceBuilder
import com.wordpress.anujsaxenadev.ui.components.image.builders.VectorBuilder

@Composable
fun DSImage(imageType: ImageType) {
    when(imageType){
        is ImageType.Resource -> {
            ResourceBuilder().build(imageType = imageType)
        }
        is ImageType.Vector -> {
            VectorBuilder().build(imageType = imageType)
        }
        is ImageType.AnimatedJson -> {
            AnimatedJsonBuilder().build(imageType = imageType)
        }
    }
}