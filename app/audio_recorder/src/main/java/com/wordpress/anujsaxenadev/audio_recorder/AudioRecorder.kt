package com.wordpress.anujsaxenadev.audio_recorder

interface AudioRecorder {
    suspend fun startRecording(fileName: String)
    suspend fun stop()
}