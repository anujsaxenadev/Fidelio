package com.wordpress.anujsaxenadev.audiorecorder.player.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.wordpress.anujsaxenadev.audiorecorder.R
import com.wordpress.anujsaxenadev.audiorecorder.core.components.AnimatedImageView
import com.wordpress.anujsaxenadev.audiorecorder.core.components.AnimationIteration

@Composable
fun PlayPauseButton(playButtonInteractionListener: OnPlayButtonInteractionListener) {
    var buttonState by remember { mutableStateOf(PlayPauseButtonState.OffState.stateValue) }
    val modifier: Modifier = Modifier.aspectRatio(1f)

    when (buttonState) {
        PlayPauseButtonState.OffState.stateValue -> {
            AnimatedImageView.getAnimatedImage(
                id = R.raw.record_button,
                iterations = AnimationIteration.OneTime,
                isPlaying = false,
                modifier = modifier.clickable {
                    buttonState = PlayPauseButtonState.OnState.stateValue
                    playButtonInteractionListener.onOn()
                })
        }

        PlayPauseButtonState.OnState.stateValue -> {
            AnimatedImageView.getAnimatedImage(
                id = R.raw.record_button,
                modifier = modifier.clickable {
                    buttonState = PlayPauseButtonState.OffState.stateValue
                    playButtonInteractionListener.onOff()
                })
        }
    }
}
sealed class PlayPauseButtonState(val stateValue: String){
    object OffState: PlayPauseButtonState("OffState")
    object OnState: PlayPauseButtonState("OnState")
}

interface OnPlayButtonInteractionListener{
    fun onOn()
    fun onOff()
}