package com.wordpress.anujsaxenadev.audiorecorder.player.repository

import android.content.Context
import com.wordpress.anujsaxenadev.audiorecorder.core.file_manager.impl.FileManager
import com.wordpress.anujsaxenadev.audiorecorder.core.logger.impl.Logger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
class AudioPlayerRepositoryModule {
    @Provides
    fun provideAudioPlayerRepository(
        @ApplicationContext context: Context,
        fileManager: FileManager,
        logger: Logger
    ): AudioPlayerRepository {
        return AudioPlayerRepositoryImpl(context, fileManager, logger)
    }
}