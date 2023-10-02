package com.wordpress.anujsaxenadev.audiorecorder.core.components.play_pause_component

sealed interface PlayerControlsType{
    fun getPlayButtonWeight(): Float = 3F
    fun getNextButtonWeight(): Float = 1F
    fun getPreviousButtonWeight(): Float = 1F
    fun get10SecReplayButtonWeight(): Float = 1F
    fun get10SecForwardButtonWeight(): Float = 1F

    object Record: PlayerControlsType
    object Player: PlayerControlsType
}