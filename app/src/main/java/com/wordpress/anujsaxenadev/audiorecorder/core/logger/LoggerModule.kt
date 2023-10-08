package com.wordpress.anujsaxenadev.audiorecorder.core.logger

import com.wordpress.anujsaxenadev.audiorecorder.core.logger.impl.Logger
import com.wordpress.anujsaxenadev.audiorecorder.core.logger.impl.LoggerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LoggerModule {
    @Singleton
    @Binds
    abstract fun bindsLogger(loggerImpl: LoggerImpl): Logger
}