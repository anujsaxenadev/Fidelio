package com.wordpress.anujsaxenadev.audiorecorder.core.file_manager

import android.content.Context
import com.wordpress.anujsaxenadev.audiorecorder.core.file_manager.impl.AndroidFileManager
import com.wordpress.anujsaxenadev.audiorecorder.core.file_manager.impl.FileManager
import com.wordpress.anujsaxenadev.audiorecorder.core.logger.impl.Logger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
class FileManagerModule {

    @Provides
    fun provideFileManager(
        @ApplicationContext appContext: Context,
        logger: Logger
    ): FileManager {
        return AndroidFileManager(appContext, logger)
    }
}