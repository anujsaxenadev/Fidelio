package com.wordpress.anujsaxenadev.date.module

import com.wordpress.anujsaxenadev.date.DateManager
import com.wordpress.anujsaxenadev.date.impl.DateManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DateManagerModule {
    @Binds
    abstract fun bindsDateManager(
        dateManagerImpl: DateManagerImpl
    ): DateManager
}