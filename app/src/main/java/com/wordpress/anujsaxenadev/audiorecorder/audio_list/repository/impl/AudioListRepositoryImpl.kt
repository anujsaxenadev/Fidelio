package com.wordpress.anujsaxenadev.audiorecorder.audio_list.repository.impl

import com.wordpress.anujsaxenadev.audiorecorder.audio_list.models.AudioFile
import com.wordpress.anujsaxenadev.audiorecorder.audio_list.repository.AudioListRepository
import com.wordpress.anujsaxenadev.audiorecorder.core.constants.ApplicationConstants
import com.wordpress.anujsaxenadev.file_manager.FileManager
import com.wordpress.anujsaxenadev.logger.Logger
import com.wordpress.anujsaxenadev.logger.helpers.tag
import javax.inject.Inject


class AudioListRepositoryImpl @Inject constructor(
    private val fileManager: FileManager,
    private val logger: Logger
) : AudioListRepository,
    Logger by logger {

    override suspend fun getAudioList(): ArrayList<AudioFile> {
        return try {
            val list = fileManager.getInternalFilesList()
            val audioList = ArrayList<AudioFile>()
            list.forEach{
                if(it.startsWith(ApplicationConstants.AUDIO_FILE_PREFIX)){
                    audioList.add(AudioFile(it))
                }
            }
            audioList
        } catch (e: Exception){
            e logThisExceptionWithTag tag
            ArrayList()
        }
    }
}