package com.wordpress.anujsaxenadev.audiorecorder.record.repository

import android.content.Context
import android.media.MediaRecorder
import android.os.Build
import java.io.File
import java.io.FileOutputStream

class AndroidAudioRecorder(private val context: Context) : AudioRecorder{
    private var recorder: MediaRecorder? = null

    private fun createRecorder(): MediaRecorder{
        return if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
            MediaRecorder(context)
        }
        else {
            MediaRecorder()
        }
    }

    override fun start(outputFile: File) {
        recorder = createRecorder().run {
            setAudioSource(MediaRecorder.AudioSource.MIC)
            setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
            setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
            setOutputFile(FileOutputStream(outputFile).fd)

            prepare()
            start()
            this
        }
    }

    override fun stop() {
        recorder?.apply {
            stop()
            reset()
        }
        recorder = null
    }
}