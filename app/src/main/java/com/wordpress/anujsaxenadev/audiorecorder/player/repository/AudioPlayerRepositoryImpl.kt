package com.wordpress.anujsaxenadev.audiorecorder.player.repository

import android.content.Context
import android.media.MediaPlayer
import androidx.core.net.toUri
import com.wordpress.anujsaxenadev.file_manager.impl.FileManager
import com.wordpress.anujsaxenadev.logger.Logger
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import javax.inject.Inject

class AudioPlayerRepositoryImpl @Inject constructor(
    @ApplicationContext
    private val  context: Context,
    private val fileManager: FileManager,
    private val logger: Logger
) : AudioPlayerRepository,
    Logger by logger{
    private var player: MediaPlayer? = null

    private fun initMediaPlayer(file: File): MediaPlayer?{
        return try {
            MediaPlayer.create(context, file.toUri())
        } catch (e: Exception){
            e logThisExceptionWithTag javaClass.name
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
            e logThisExceptionWithTag javaClass.name
            null
        }
    }

    override suspend fun play() {
        try {
            player?.start()
        } catch (e: Exception){
            e logThisExceptionWithTag javaClass.name
        }
    }

    override suspend fun pause(){
        try {
            player?.pause()
        }
        catch (e: Exception){
            e logThisExceptionWithTag javaClass.name
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
            e logThisExceptionWithTag javaClass.name
        }
    }
}


data class PlayerMetaData(val duration: Int)