package com.wordpress.anujsaxenadev.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun DSImage(imageType: ImageType) {
    when(imageType){
        is ImageType.Resource -> {
            Image(
                modifier = imageType.modifier ?: Modifier,
                painter = painterResource(id = imageType.resourceId),
                contentDescription = imageType.description,
                contentScale = imageType.contentScale ?: ImageType.DefaultImageContentScale,
            )
        }
        is ImageType.Vector -> {
            Image(
                modifier = imageType.modifier ?: Modifier,
                imageVector = imageType.imageVector,
                colorFilter = imageType.colorFilter,
                contentDescription = imageType.description,
                contentScale = imageType.contentScale ?: ImageType.DefaultImageContentScale,
            )
        }
    }
}