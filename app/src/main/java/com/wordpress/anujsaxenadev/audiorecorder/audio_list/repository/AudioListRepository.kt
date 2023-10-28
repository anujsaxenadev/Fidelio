package com.wordpress.anujsaxenadev.audiorecorder.audio_list.repository

import com.wordpress.anujsaxenadev.audiorecorder.audio_list.models.AudioFile

/**
 * Interface Responsible for Managing the Audio files stored in Internal Storage.
 * @see `AudioListRepositoryImpl` for Implementations.
 */
interface AudioListRepository {

    /**
     * Fetches the Audio List stored in Internal Storage
     *
     * @return `List` of [AudioFile] containing the audio meta information.
     */
    suspend fun getAudioList() : ArrayList<AudioFile>
}