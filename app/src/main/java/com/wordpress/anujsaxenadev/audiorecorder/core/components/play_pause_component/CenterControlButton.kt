package com.wordpress.anujsaxenadev.audiorecorder.core.components.play_pause_component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.wordpress.anujsaxenadev.audiorecorder.core.components.play_pause_component.play_pause_button.PlayPauseButton
import com.wordpress.anujsaxenadev.audiorecorder.core.components.play_pause_component.play_pause_button.PlayPauseInteractionListener
import com.wordpress.anujsaxenadev.audiorecorder.core.components.play_pause_component.record_button.RecordButtonInteractionListener
import com.wordpress.anujsaxenadev.audiorecorder.core.components.play_pause_component.record_button.RecordButton

@Composable
fun CenterControlButton(
    modifier: Modifier,
    playerControlsType: PlayerControlsType,
    playerControlsListener: PlayerControlsListener?,
    recordControlsListener: RecordControlsListener?,
    duration: Int?,
){
    when(playerControlsType){
        PlayerControlsType.Player -> {
            duration?.let {
                PlayPauseButton(duration, object : PlayPauseInteractionListener {
                    override fun onInitCompleted() {
                        playerControlsListener?.onPlay()
                    }

                    override fun onPause() {
                        playerControlsListener?.onPause()
                    }

                    override fun onResume() {
                        playerControlsListener?.onPlay()
                    }
                }, modifier = modifier)
            }
        }
        PlayerControlsType.Record -> {
            RecordButton(object : RecordButtonInteractionListener {
                override fun onRecord() {
                    recordControlsListener?.onResume()
                }

                override fun onStop() {
                    recordControlsListener?.onPause()
                }
            }, modifier = modifier)
        }
    }
}