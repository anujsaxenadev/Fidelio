package com.wordpress.anujsaxenadev.file_manager.module

import com.wordpress.anujsaxenadev.file_manager.FileManager
import com.wordpress.anujsaxenadev.file_manager.impl.AndroidFileManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FileManagerModule {
    @Binds
    abstract fun bindsFileManager(androidFileManager: AndroidFileManager): FileManager
}