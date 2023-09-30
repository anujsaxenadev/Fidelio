package com.wordpress.anujsaxenadev.audiorecorder.core.logger

import com.wordpress.anujsaxenadev.audiorecorder.core.logger.impl.Logger
import com.wordpress.anujsaxenadev.audiorecorder.core.logger.impl.LoggerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LoggerModule {
    @Singleton
    @Provides
    fun provideLogger(): Logger {
        return LoggerImpl()
    }
}