package com.wordpress.anujsaxenadev.ui.components.image.builders

import androidx.compose.runtime.Composable
import com.wordpress.anujsaxenadev.ui.components.image.ImageType

interface ImageBuilder<T: ImageType>{
    @Composable
    fun build(imageType: T)
}