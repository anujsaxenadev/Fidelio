package com.wordpress.anujsaxenadev.ui.components.image.builders

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.wordpress.anujsaxenadev.ui.components.image.ImageType

class ResourceBuilder : ImageBuilder<ImageType.Resource> {
    @Composable
    override fun build(imageType: ImageType.Resource) {
        Image(
            modifier = imageType.modifier ?: Modifier,
            painter = painterResource(id = imageType.resourceId),
            contentDescription = imageType.description,
            contentScale = imageType.contentScale ?: ImageType.DefaultImageContentScale,
        )
    }
}