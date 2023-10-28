package com.wordpress.anujsaxenadev.audiorecorder.record.repository.module

import com.wordpress.anujsaxenadev.audiorecorder.record.repository.AudioRecorderRepository
import com.wordpress.anujsaxenadev.audiorecorder.record.repository.impl.AudioRecorderRepositoryRepositoryImpl
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