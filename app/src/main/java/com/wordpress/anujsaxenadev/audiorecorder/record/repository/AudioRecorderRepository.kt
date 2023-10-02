package com.wordpress.anujsaxenadev.audiorecorder.record.repository

interface AudioRecorderRepository {
    suspend fun start()
    suspend fun stop()
}