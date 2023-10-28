package com.wordpress.anujsaxenadev.audiorecorder.player.repository

import com.wordpress.anujsaxenadev.audiorecorder.player.models.PlayerMetaData

/**
 * Interface Responsible for Dealing with Audio Files.
 * @see `AudioPlayerRepositoryImpl` for implementations.
 */
interface AudioPlayerRepository {

    /**
     * To play the media that has been initialised in `initPlayer`.
     * Ensure that `initPlayer` is called before use.
     */
    suspend fun play()

    /**
     * Initialises the Media Player.
     *
     * @param fileName reference of the file that we need to manage.
     */
    suspend fun initPlayer(fileName: String): PlayerMetaData

    /**
     * To pause the media that has been initialised in `initPlayer`.
     * Ensure that `initPlayer` is called before use.
     */
    suspend fun pause()

    /**
     * To stop the media and release media resources that has been initialised in `initPlayer`.
     * Ensure that `initPlayer` is called before use.
     */
    suspend fun stop()
}