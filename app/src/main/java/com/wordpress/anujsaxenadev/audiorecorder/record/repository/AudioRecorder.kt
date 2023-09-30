package com.wordpress.anujsaxenadev.audiorecorder.record.repository

import java.io.File

interface AudioRecorder {
    fun start(outputFile: File)
    fun stop()
}