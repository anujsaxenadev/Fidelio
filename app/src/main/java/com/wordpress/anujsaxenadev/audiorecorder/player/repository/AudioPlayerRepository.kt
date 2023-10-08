package com.wordpress.anujsaxenadev.audiorecorder.player.repository

interface AudioPlayerRepository {
    suspend fun play(fileName: String)
    suspend fun getDuration(): Int
    suspend fun pause()
    suspend fun stop()
}