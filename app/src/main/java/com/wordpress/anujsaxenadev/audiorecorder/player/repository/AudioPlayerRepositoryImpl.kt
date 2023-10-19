package com.wordpress.anujsaxenadev.audiorecorder.player.repository

import android.content.Context
import android.media.MediaPlayer
import androidx.core.net.toUri
import com.wordpress.anujsaxenadev.audiorecorder.core.file_manager.impl.FileManager
import com.wordpress.anujsaxenadev.logger.impl.LogType
import com.wordpress.anujsaxenadev.logger.impl.Logger
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import javax.inject.Inject

class AudioPlayerRepositoryImpl @Inject constructor(
    @ApplicationContext
    private val  context: Context,
    private val fileManager: FileManager,
    private val logger: Logger
) : AudioPlayerRepository{
    private var player: MediaPlayer? = null

    private fun initMediaPlayer(file: File): MediaPlayer?{
        return try {
            MediaPlayer.create(context, file.toUri())
        } catch (e: Exception){
            logger.log(LogType.LOGCAT, this.javaClass.name, e)
            null
        }
    }

    override suspend fun initPlayer(fileName: String): PlayerMetaData?{
        return try {
            stop()
            val file = fileManager.getFile(fileName)
            if(file != null){
                val player = initMediaPlayer(file)
                return if(player != null){
                    this.player = player
                    PlayerMetaData(player.duration)
                }
                else{
                    null
                }
            }
            else{
                return null
            }
        } catch (e: Exception){
            logger.log(LogType.LOGCAT, this.javaClass.name, e)
            null
        }
    }

    override suspend fun play() {
        try {
            player?.start()
        } catch (e: Exception){
            logger.log(LogType.LOGCAT, this.javaClass.name, e)
        }
    }

    override suspend fun pause(){
        try {
            player?.pause()
        }
        catch (e: Exception){
            logger.log(LogType.LOGCAT, this.javaClass.name, e)
        }
    }

    override suspend fun stop() {
        try {
            player?.apply {
                stop()
                release()
            }
            player = null
        } catch (e: Exception){
            logger.log(LogType.LOGCAT, this.javaClass.name, e)
        }
    }
}


data class PlayerMetaData(val duration: Int)