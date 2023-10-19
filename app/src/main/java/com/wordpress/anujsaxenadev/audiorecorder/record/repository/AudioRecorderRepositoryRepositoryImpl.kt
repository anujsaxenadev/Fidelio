package com.wordpress.anujsaxenadev.audiorecorder.record.repository

import android.content.Context
import android.media.MediaRecorder
import android.os.Build
import com.wordpress.anujsaxenadev.audiorecorder.core.file_manager.impl.FileManager
import com.wordpress.anujsaxenadev.audiorecorder.date.impl.DateFormats
import com.wordpress.anujsaxenadev.audiorecorder.date.impl.DateManager
import com.wordpress.anujsaxenadev.logger.impl.LogType
import com.wordpress.anujsaxenadev.logger.impl.Logger
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AudioRecorderRepositoryRepositoryImpl @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val dateManager: DateManager,
    private val fileManager: FileManager,
    private val logger: Logger
) : AudioRecorderRepository{

    companion object{
        private const val AUDIO_FORMAT: String = ".mp4"
    }

    private var recorder: MediaRecorder? = null

    private fun createRecorder(): MediaRecorder?{
        return try {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
                MediaRecorder(context)
            } else {
                MediaRecorder()
            }
        } catch (e: Exception){
            logger.log(LogType.LOGCAT, javaClass.name, e)
            null
        }
    }

    private suspend fun suggestAudioFileName() : String?{
        return try{
            FileManager.AUDIO_FILE_PREFIX + dateManager.getTodayInFormat(DateFormats.DD_MM_YYYY_HH_MM_SS.format) + AUDIO_FORMAT
        } catch (e: Exception){
            null
        }
    }

    override suspend fun start() {
        try {
            suggestAudioFileName()?.let {
                recorder = createRecorder()?.run {
                    setAudioSource(MediaRecorder.AudioSource.MIC)
                    setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
                    setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
                    setOutputFile(fileManager.createFileStream(it))

                    prepare()
                    start()
                    this
                }
            }
        }
        catch (e: Exception){
            logger.log(LogType.LOGCAT, javaClass.name, e)
        }
    }

    override suspend fun stop() {
        try {
            recorder?.apply {
                stop()
                reset()
            }
            recorder = null
        }
        catch (e: Exception){
            logger.log(LogType.LOGCAT, javaClass.name, e)
        }
    }
}