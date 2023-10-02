package com.wordpress.anujsaxenadev.audiorecorder.player.repository

import android.content.Context
import android.media.MediaPlayer
import androidx.core.net.toUri
import com.wordpress.anujsaxenadev.audiorecorder.core.file_manager.impl.FileManager
import com.wordpress.anujsaxenadev.audiorecorder.core.logger.impl.LogType
import com.wordpress.anujsaxenadev.audiorecorder.core.logger.impl.Logger
import java.io.File

class AudioPlayerRepositoryImpl(
    private val context: Context,
    private val fileManager: FileManager,
    private val logger: Logger
) : AudioPlayerRepository{
    private var player: MediaPlayer? = null

    private fun createPlayer(file: File): MediaPlayer?{
        return try {
            MediaPlayer.create(context, file.toUri())
        } catch (e: Exception){
            logger.log(LogType.LOGCAT, this.javaClass.name, e)
            null
        }
    }

    override suspend fun playFile(fileName: String) {
        try {
            fileManager.getFile(fileName)?.let {
                createPlayer(it)?.apply {
                    player = this
                    start()
                }
            }
        } catch (e: Exception){
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