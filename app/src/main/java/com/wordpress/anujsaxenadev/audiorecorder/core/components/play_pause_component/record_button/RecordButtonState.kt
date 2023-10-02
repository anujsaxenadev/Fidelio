package com.wordpress.anujsaxenadev.audiorecorder.core.components.play_pause_component.record_button

sealed class RecordButtonState(val stateValue: String){
    object OnStop: RecordButtonState("OnStop")
    object OnRecord: RecordButtonState("OnRecord")
}