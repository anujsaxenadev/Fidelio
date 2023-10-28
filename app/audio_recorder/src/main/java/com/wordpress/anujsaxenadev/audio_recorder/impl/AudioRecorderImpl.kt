package com.wordpress.anujsaxenadev.audio_recorder.impl

import android.content.Context
import android.media.MediaRecorder
import android.os.Build
import com.wordpress.anujsaxenadev.audio_recorder.AudioRecorder
import com.wordpress.anujsaxenadev.file_manager.FileManager
import com.wordpress.anujsaxenadev.logger.Logger
import com.wordpress.anujsaxenadev.logger.helpers.tag
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AudioRecorderImpl @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val logger: Logger,
    private val fileManager: FileManager,
): AudioRecorder, Logger by logger {
    private var recorder: MediaRecorder? = null

    private suspend fun initRecorder(): MediaRecorder?{
        recorder = try {
            if(recorder != null){
                stop()
            }
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
                MediaRecorder(context)
            } else {
                MediaRecorder()
            }
        } catch (e: Exception){
            e logThisExceptionWithTag tag
            null
        }
        return recorder
    }

    override suspend fun startRecording(fileName: String){
        try {
            initRecorder()?.run {
                setAudioSource(MediaRecorder.AudioSource.MIC)
                setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
                setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
                setOutputFile(fileManager.createInternalFileStream(fileName))

                prepare()
                start()
                this
            }
        }
        catch (e: Exception){
            e logThisExceptionWithTag tag
        }
    }

    override suspend fun stop() {
        try {
            recorder?.apply {
                stop()
                reset()
            }
            recorder = null
            fileManager.releaseResources()
        }
        catch (e: Exception){
            e logThisExceptionWithTag tag
        }
    }
}