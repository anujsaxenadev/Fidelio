package com.wordpress.anujsaxenadev.audiorecorder.audio_list.repository.impl

import com.wordpress.anujsaxenadev.audiorecorder.audio_list.models.AudioFile

interface AudioListRepository {

    suspend fun suggestAudioFileName(): String
    suspend fun getAudioList() : ArrayList<AudioFile>
}