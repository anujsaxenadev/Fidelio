package com.wordpress.anujsaxenadev.audiorecorder.date

import com.wordpress.anujsaxenadev.audiorecorder.date.impl.DateManager
import com.wordpress.anujsaxenadev.audiorecorder.date.impl.DateManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DateManagerModule {
    @Binds
    abstract fun bindsDateManager(
        dateManagerImpl: DateManagerImpl
    ): DateManager
}