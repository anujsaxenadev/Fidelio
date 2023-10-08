package com.wordpress.anujsaxenadev.audiorecorder.player.repository

interface AudioPlayerRepository {
    suspend fun play()
    suspend fun initPlayer(fileName: String): PlayerMetaData?
    suspend fun pause()
    suspend fun stop()
}