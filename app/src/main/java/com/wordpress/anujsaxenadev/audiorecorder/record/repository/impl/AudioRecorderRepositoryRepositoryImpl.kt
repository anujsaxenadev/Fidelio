package com.wordpress.anujsaxenadev.audiorecorder.record.repository.impl

import com.wordpress.anujsaxenadev.audio_recorder.AudioRecorder
import com.wordpress.anujsaxenadev.audiorecorder.core.constants.ApplicationConstants
import com.wordpress.anujsaxenadev.audiorecorder.record.repository.AudioRecorderRepository
import com.wordpress.anujsaxenadev.date.DateManager
import com.wordpress.anujsaxenadev.date.impl.DateFormats
import com.wordpress.anujsaxenadev.logger.Logger
import com.wordpress.anujsaxenadev.logger.helpers.tag
import javax.inject.Inject

class AudioRecorderRepositoryRepositoryImpl @Inject constructor(
    private val dateManager: DateManager,
    private val logger: Logger,
    private val audioRecorder: AudioRecorder
) : AudioRecorderRepository,
    Logger by logger{

    companion object{
        private const val AUDIO_FORMAT: String = ".mp4"
    }

    private suspend fun suggestAudioFileName() : String?{
        return try{
            ApplicationConstants.AUDIO_FILE_PREFIX + dateManager.getTodayInFormat(DateFormats.DDMMMYYHHMMSS.format) + AUDIO_FORMAT
        } catch (e: Exception){
            null
        }
    }

    override suspend fun start() {
        try {
            suggestAudioFileName()?.let {
                audioRecorder.startRecording(it)
            }
        }
        catch (e: Exception){
            e logThisExceptionWithTag tag
        }
    }

    override suspend fun stop() {
        try {
            audioRecorder.stop()
        }
        catch (e: Exception){
            e logThisExceptionWithTag tag
        }
    }
}