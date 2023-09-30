package com.wordpress.anujsaxenadev.audiorecorder.audio_list.repository

import com.wordpress.anujsaxenadev.audiorecorder.audio_list.repository.impl.AudioListRepository
import com.wordpress.anujsaxenadev.audiorecorder.audio_list.repository.impl.AudioListRepositoryImpl
import com.wordpress.anujsaxenadev.audiorecorder.core.file_manager.impl.FileManager
import com.wordpress.anujsaxenadev.audiorecorder.date.impl.DateManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class AudioListRepositoryModule {

    @Provides
    fun provideAudioListRepository(
        fileManager: FileManager,
        dateManager: DateManager
    ): AudioListRepository {
        return AudioListRepositoryImpl(fileManager, dateManager)
    }
}