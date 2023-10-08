package com.wordpress.anujsaxenadev.audiorecorder.player.repository

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