package com.wordpress.anujsaxenadev.audio_recorder.module

import com.wordpress.anujsaxenadev.audio_recorder.AudioRecorder
import com.wordpress.anujsaxenadev.audio_recorder.impl.AudioRecorderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AudioRecorderModule {
    @Binds
    abstract fun bindsAudioRecorder(audioRecorderImpl: AudioRecorderImpl): AudioRecorder
}