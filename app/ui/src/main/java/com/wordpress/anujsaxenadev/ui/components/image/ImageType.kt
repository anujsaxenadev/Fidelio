package com.wordpress.anujsaxenadev.ui.components.image

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import com.wordpress.anujsaxenadev.ui.components.image.builders.AnimationIteration

sealed interface ImageType {
    companion object {
        val DefaultImageContentScale = ContentScale.Crop
    }

    class Resource(val resourceId: Int,
                   val modifier: Modifier? = null,
                   val description: String? = null,
                   val contentScale: ContentScale? = null,
    ): ImageType

    class Vector(val imageVector: ImageVector,
                 val modifier: Modifier? = null,
                 val description: String? = null,
                 val contentScale: ContentScale? = null,
                 val colorFilter: ColorFilter? = null,
    ): ImageType

    class AnimatedJson(
        val id: Int,
        val modifier: Modifier? = null,
        val contentScale: ContentScale? = null,
        val iterations: AnimationIteration? = null,
        val isPlaying: Boolean? = null,
        val progress: (() -> Float)? = null): ImageType
}
