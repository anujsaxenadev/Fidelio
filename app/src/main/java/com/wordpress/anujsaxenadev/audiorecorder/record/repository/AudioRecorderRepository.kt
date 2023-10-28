package com.wordpress.anujsaxenadev.audiorecorder.record.repository

/**
 * Interface Responsible for Dealing with Audio Recording.
 * @see `AudioRecorderRepositoryImpl` for implementations.
 */
interface AudioRecorderRepository {

    /**
     * To Start Recording the Audio from Microphone and saving the media in Internal Storage.
     */
    suspend fun start()

    /**
     * To Stop Recording the ongoing Audio Recording.
     */
    suspend fun stop()
}