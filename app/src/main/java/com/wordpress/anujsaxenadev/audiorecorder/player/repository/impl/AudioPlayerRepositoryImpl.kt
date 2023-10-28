package com.wordpress.anujsaxenadev.audiorecorder.player.repository.impl

import com.wordpress.anujsaxenadev.audiorecorder.player.models.PlayerMetaData
import com.wordpress.anujsaxenadev.audiorecorder.player.repository.AudioPlayerRepository
import com.wordpress.anujsaxenadev.file_manager.FileManager
import com.wordpress.anujsaxenadev.logger.Logger
import com.wordpress.anujsaxenadev.logger.helpers.tag
import com.wordpress.anujsaxenadev.media.MediaManager
import javax.inject.Inject

class AudioPlayerRepositoryImpl @Inject constructor(
    private val fileManager: FileManager,
    private val mediaManager: MediaManager,
    private val logger: Logger
) : AudioPlayerRepository, Logger by logger {

    override suspend fun initPlayer(fileName: String): PlayerMetaData {
        return try {
            val file = fileManager.getInternalFile(fileName)
            if(file != null){
                mediaManager.initManager(file)
                PlayerMetaData(mediaManager.getDuration())
            } else{
                PlayerMetaData(0)
            }
        } catch (e: Exception){
            e logThisExceptionWithTag tag
            PlayerMetaData(0)
        }
    }

    override suspend fun play() {
        try {
            mediaManager.play()
        }
        catch (e: Exception){
            e logThisExceptionWithTag tag
        }
    }

    override suspend fun pause(){
        try {
            mediaManager.pause()
        }
        catch (e: Exception){
            e logThisExceptionWithTag tag
        }
    }

    override suspend fun stop() {
        try {
            mediaManager.stop()
        }
        catch (e: Exception){
            e logThisExceptionWithTag tag
        }
    }
}