package com.wordpress.anujsaxenadev.audiorecorder.audio_list.repository

import com.wordpress.anujsaxenadev.audiorecorder.audio_list.repository.impl.AudioListRepository
import com.wordpress.anujsaxenadev.audiorecorder.audio_list.repository.impl.AudioListRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class AudioListRepositoryModule {

    @Binds
    abstract fun bindsAudioListRepository(
        audioListRepositoryImpl: AudioListRepositoryImpl
    ): AudioListRepository
}