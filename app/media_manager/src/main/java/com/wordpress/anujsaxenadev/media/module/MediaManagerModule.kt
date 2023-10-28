package com.wordpress.anujsaxenadev.media.module

import com.wordpress.anujsaxenadev.media.MediaManager
import com.wordpress.anujsaxenadev.media.impl.MediaManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MediaManagerModule {
    @Binds
    abstract fun bindsMediaManager(
        mediaManagerImpl: MediaManagerImpl
    ): MediaManager
}