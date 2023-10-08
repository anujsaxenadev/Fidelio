package com.wordpress.anujsaxenadev.audiorecorder.record.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class AudioRecorderRepositoryModule {
    @Binds
    abstract fun bindsAudioRecorderRepository(audioRecorderRepositoryRepositoryImpl: AudioRecorderRepositoryRepositoryImpl): AudioRecorderRepository
}