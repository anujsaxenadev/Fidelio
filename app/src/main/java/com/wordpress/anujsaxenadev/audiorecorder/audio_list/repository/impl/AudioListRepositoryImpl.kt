package com.wordpress.anujsaxenadev.audiorecorder.audio_list.repository.impl

import com.wordpress.anujsaxenadev.audiorecorder.audio_list.models.AudioFile
import com.wordpress.anujsaxenadev.audiorecorder.core.file_manager.impl.FileManager


class AudioListRepositoryImpl(
    private val fileManager: FileManager) : AudioListRepository {

    override suspend fun getAudioList(): ArrayList<AudioFile> {
        val list = fileManager.getInternalFilesList()
        val audioList = ArrayList<AudioFile>()
        list.forEach{
            if(it.startsWith(FileManager.AUDIO_FILE_PREFIX)){
                audioList.add(AudioFile(it))
            }
        }
       return audioList
    }
}