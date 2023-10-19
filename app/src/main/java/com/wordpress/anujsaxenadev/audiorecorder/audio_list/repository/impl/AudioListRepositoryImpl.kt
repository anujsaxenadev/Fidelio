package com.wordpress.anujsaxenadev.audiorecorder.audio_list.repository.impl

import com.wordpress.anujsaxenadev.audiorecorder.audio_list.models.AudioFile
import com.wordpress.anujsaxenadev.file_manager.impl.FileManager
import com.wordpress.anujsaxenadev.logger.impl.LogType
import com.wordpress.anujsaxenadev.logger.impl.Logger
import javax.inject.Inject


class AudioListRepositoryImpl @Inject constructor(
    private val fileManager: FileManager,
    private val logger: Logger
) : AudioListRepository {

    override suspend fun getAudioList(): ArrayList<AudioFile> {
        return try {
            val list = fileManager.getInternalFilesList()
            val audioList = ArrayList<AudioFile>()
            list.forEach{
                if(it.startsWith(FileManager.AUDIO_FILE_PREFIX)){
                    audioList.add(AudioFile(it))
                }
            }
            audioList
        } catch (e: Exception){
            logger.log(LogType.LOGCAT, this.javaClass.name, e)
            ArrayList()
        }
    }
}