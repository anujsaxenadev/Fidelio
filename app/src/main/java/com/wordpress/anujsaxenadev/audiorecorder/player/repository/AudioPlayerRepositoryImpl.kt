package com.wordpress.anujsaxenadev.audiorecorder.player.repository

import com.wordpress.anujsaxenadev.file_manager.FileManager
import com.wordpress.anujsaxenadev.media.MediaManager
import javax.inject.Inject

class AudioPlayerRepositoryImpl @Inject constructor(
    private val fileManager: FileManager,
    private val mediaManager: MediaManager
) : AudioPlayerRepository{

    override suspend fun initPlayer(fileName: String): PlayerMetaData{
        val file = fileManager.getInternalFile(fileName)
        return if(file != null){
            mediaManager.initManager(file)
            PlayerMetaData(mediaManager.getDuration())
        }
        else{
            PlayerMetaData(0)
        }
    }

    override suspend fun play() {
        mediaManager.play()
    }

    override suspend fun pause(){
        mediaManager.pause()
    }

    override suspend fun stop() {
        mediaManager.stop()
    }
}


data class PlayerMetaData(val duration: Int)