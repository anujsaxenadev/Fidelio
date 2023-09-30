package com.wordpress.anujsaxenadev.audiorecorder.player.repository

import java.io.File

interface AudioPlayer {
    fun playFile(file: File)
    fun stop()
}