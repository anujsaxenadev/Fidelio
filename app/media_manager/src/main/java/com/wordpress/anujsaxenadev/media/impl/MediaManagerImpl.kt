package com.wordpress.anujsaxenadev.media.impl

import android.content.Context
import android.media.MediaPlayer
import androidx.core.net.toUri
import com.wordpress.anujsaxenadev.logger.Logger
import com.wordpress.anujsaxenadev.logger.helpers.tag
import com.wordpress.anujsaxenadev.media.MediaManager
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import javax.inject.Inject

class MediaManagerImpl @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val logger: Logger
): MediaManager, Logger by logger{
    private var player: MediaPlayer? = null

    override suspend fun initManager(file: File){
        player = try {
            if(player != null){
                stop()
            }
            MediaPlayer.create(context, file.toUri())
        } catch (e: Exception){
            e logThisExceptionWithTag tag
            null
        }
    }

    override suspend fun play() {
        try {
            player?.start()
        }
        catch (e: Exception){
            e logThisExceptionWithTag tag
        }
    }

    override suspend fun pause(){
        try {
            player?.pause()
        }
        catch (e: Exception){
            e logThisExceptionWithTag tag
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
            e logThisExceptionWithTag tag
        }
    }

    override suspend fun getDuration(): Int {
        return player?.duration ?: 0
    }
}