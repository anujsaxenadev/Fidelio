package com.wordpress.anujsaxenadev.date

import com.wordpress.anujsaxenadev.date.impl.DateManager
import com.wordpress.anujsaxenadev.date.impl.DateManagerImpl
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