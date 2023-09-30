package com.wordpress.anujsaxenadev.audiorecorder.player.repository

import android.content.Context
import android.media.MediaPlayer
import androidx.core.net.toUri
import java.io.File

class AndroidAudioPlayer(private val context: Context) : AudioPlayer{
    private var player: MediaPlayer? = null

    private fun createPlayer(file: File): MediaPlayer{
        return MediaPlayer.create(context, file.toUri())
    }

    override fun playFile(file: File) {
        createPlayer(file).apply {
            player = this
            start()
        }
    }

    override fun stop() {
        player?.apply {
            stop()
            release()
        }
        player = null
    }
}