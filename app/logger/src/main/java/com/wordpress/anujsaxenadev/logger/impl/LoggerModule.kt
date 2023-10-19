package com.wordpress.anujsaxenadev.logger.impl

import com.wordpress.anujsaxenadev.logger.Logger
import com.wordpress.anujsaxenadev.logger.impl.LoggerImpl
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