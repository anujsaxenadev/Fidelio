package com.wordpress.anujsaxenadev.audiorecorder.player.repository.module

import com.wordpress.anujsaxenadev.audiorecorder.player.repository.AudioPlayerRepository
import com.wordpress.anujsaxenadev.audiorecorder.player.repository.impl.AudioPlayerRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class AudioPlayerRepositoryModule {
    @Binds
    abstract fun bindsAudioPlayerRepository(audioPlayerRepositoryImpl: AudioPlayerRepositoryImpl): AudioPlayerRepository
}