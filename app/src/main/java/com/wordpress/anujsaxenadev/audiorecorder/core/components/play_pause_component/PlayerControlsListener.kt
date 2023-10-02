package com.wordpress.anujsaxenadev.audiorecorder.core.components.play_pause_component

interface PlayerControlsListener{
    fun onPlay()
    fun onPause()
    fun onNext()
    fun onPrevious()
    fun on10SecReplay()
    fun on10SecForward()
}