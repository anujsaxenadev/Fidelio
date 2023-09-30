package com.wordpress.anujsaxenadev.audiorecorder.audio_list.repository.impl

import com.wordpress.anujsaxenadev.audiorecorder.audio_list.models.AudioFile
import com.wordpress.anujsaxenadev.audiorecorder.core.file_manager.impl.AndroidFileManager
import com.wordpress.anujsaxenadev.audiorecorder.core.file_manager.impl.FileManager
import com.wordpress.anujsaxenadev.audiorecorder.date.impl.DateFormats
import com.wordpress.anujsaxenadev.audiorecorder.date.impl.DateManager

class AudioListRepositoryImpl(
    private val fileManager: FileManager,
    private val dateManager: DateManager) : AudioListRepository {

    companion object{
        private const val AUDIO_FORMAT: String = ".mp4"
    }
    override suspend fun getAudioList(): ArrayList<AudioFile> {
        val list = fileManager.getInternalFilesList()
        val audioList = ArrayList<AudioFile>()
        list.forEach{
//            if(it.startsWith(AndroidFileManager.AUDIO_FILE_PREFIX)){
                audioList.add(AudioFile(it))
//            }
        }
       return audioList
    }

    override suspend fun suggestAudioFileName() : String{
        return AndroidFileManager.AUDIO_FILE_PREFIX + dateManager.getTodayInFormat(DateFormats.DD_MM_YYYY_HH_MM_SS.format) + AUDIO_FORMAT
    }
}