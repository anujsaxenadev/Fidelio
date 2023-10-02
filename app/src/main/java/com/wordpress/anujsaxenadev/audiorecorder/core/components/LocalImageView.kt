package com.wordpress.anujsaxenadev.audiorecorder.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

class LocalImageView{
    companion object{
        private val DefaultContentScale: ContentScale = ContentScale.Crop
        private val DefaultModifier: Modifier = Modifier.aspectRatio(1f)
        private const val DefaultLocalImageDescription: String = "Local Image"

        @Composable
        fun getLocalImage(
            id: Int,
            description: String? = DefaultLocalImageDescription,
            contentScale: ContentScale? = DefaultContentScale,
            modifier: Modifier? = null
        ) {
            Image(
                painter = painterResource(id = id),
                contentDescription = description,
                contentScale = contentScale ?: DefaultContentScale,
                modifier = modifier ?: DefaultModifier
            )
        }

        @Composable
        fun getLocalImage(
            imageVector: ImageVector,
            colorFilter: ColorFilter,
            description: String? = DefaultLocalImageDescription,
            contentScale: ContentScale? = DefaultContentScale,
            modifier: Modifier? = null
        ) {
            Image(
                imageVector = imageVector,
                contentDescription = description,
                contentScale = contentScale ?: DefaultContentScale,
                modifier = modifier ?: DefaultModifier,
                colorFilter = colorFilter
            )
        }
    }
}
