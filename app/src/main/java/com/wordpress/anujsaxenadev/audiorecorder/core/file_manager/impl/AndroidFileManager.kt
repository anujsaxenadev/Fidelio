package com.wordpress.anujsaxenadev.audiorecorder.core.file_manager.impl

import android.content.Context
import com.wordpress.anujsaxenadev.audiorecorder.core.logger.impl.LogType
import com.wordpress.anujsaxenadev.audiorecorder.core.logger.impl.Logger

class AndroidFileManager(
    private val context: Context,
    private val logger: Logger) : FileManager {

    companion object{
        const val AUDIO_FILE_PREFIX: String = "AUDIO-REC-"
    }

    override suspend fun getInternalFilesList() : Array<String>{
        return try {
            context.fileList()
        } catch (e: Exception){
            logger.log(LogType.LOGCAT, this.javaClass.name, e)
            arrayOf()
        }
    }

}