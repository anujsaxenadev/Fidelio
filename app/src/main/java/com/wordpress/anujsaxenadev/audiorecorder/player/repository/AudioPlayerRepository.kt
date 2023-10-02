package com.wordpress.anujsaxenadev.audiorecorder.player.repository

interface AudioPlayerRepository {
    suspend fun playFile(fileName: String)
    suspend fun stop()
}