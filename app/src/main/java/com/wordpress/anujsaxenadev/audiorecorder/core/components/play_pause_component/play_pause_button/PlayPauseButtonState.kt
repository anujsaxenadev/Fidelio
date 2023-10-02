package com.wordpress.anujsaxenadev.audiorecorder.core.components.play_pause_component.play_pause_button

sealed class PlayPauseButtonState(val stateValue: String){
    object OnPause: PlayPauseButtonState("OnPause")

    object OnInitCompleted: PlayPauseButtonState("OnInitCompleted")
    object OnResume: PlayPauseButtonState("OnResume")
}