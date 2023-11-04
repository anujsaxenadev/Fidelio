package com.wordpress.anujsaxenadev.ui.components.image

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale

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
}
