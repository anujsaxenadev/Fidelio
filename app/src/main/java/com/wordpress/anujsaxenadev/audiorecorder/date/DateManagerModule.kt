package com.wordpress.anujsaxenadev.audiorecorder.date

import com.wordpress.anujsaxenadev.audiorecorder.core.logger.impl.Logger
import com.wordpress.anujsaxenadev.audiorecorder.date.impl.DateManager
import com.wordpress.anujsaxenadev.audiorecorder.date.impl.DateManagerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DateManagerModule {
    @Provides
    fun provideDateManager(
        logger: Logger
    ): DateManager {
        return DateManagerImpl(logger)
    }
}