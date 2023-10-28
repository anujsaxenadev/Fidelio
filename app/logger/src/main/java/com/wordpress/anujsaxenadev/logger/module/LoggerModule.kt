package com.wordpress.anujsaxenadev.logger.module

import com.wordpress.anujsaxenadev.logger.Logger
import com.wordpress.anujsaxenadev.logger.impl.LogcatLogger
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LoggerModule {
    @Binds
    abstract fun bindsLogger(logcatLogger: LogcatLogger): Logger
}