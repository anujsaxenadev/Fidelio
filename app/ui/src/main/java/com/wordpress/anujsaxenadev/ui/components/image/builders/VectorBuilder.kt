package com.wordpress.anujsaxenadev.ui.components.image.builders

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.wordpress.anujsaxenadev.ui.components.image.ImageType

class VectorBuilder: ImageBuilder<ImageType.Vector> {
    @Composable
    override fun build(imageType: ImageType.Vector){
        Image(
            modifier = imageType.modifier ?: Modifier,
            imageVector = imageType.imageVector,
            colorFilter = imageType.colorFilter,
            contentDescription = imageType.description,
            contentScale = imageType.contentScale ?: ImageType.DefaultImageContentScale,
        )
    }
}