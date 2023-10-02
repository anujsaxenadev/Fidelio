package com.wordpress.anujsaxenadev.audiorecorder.record.repository

import android.content.Context
import com.wordpress.anujsaxenadev.audiorecorder.core.file_manager.impl.FileManager
import com.wordpress.anujsaxenadev.audiorecorder.core.logger.impl.Logger
import com.wordpress.anujsaxenadev.audiorecorder.date.impl.DateManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext


@Module
@InstallIn(ViewModelComponent::class)
class AudioRecorderRepositoryModule {
    @Provides
    fun provideAudioRecorderRepository(
        @ApplicationContext context: Context,
        dateManager: DateManager,
        fileManager: FileManager,
        logger: Logger): AudioRecorderRepository {
        return AudioRecorderRepositoryRepositoryImpl(context, dateManager, fileManager, logger)
    }
}