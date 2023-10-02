package com.wordpress.anujsaxenadev.audiorecorder.core.components.play_pause_component.play_pause_button

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.wordpress.anujsaxenadev.audiorecorder.R
import com.wordpress.anujsaxenadev.audiorecorder.core.components.AnimatedImageView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun PlayPauseButton(
    durationInMillis: Int,
    playButtonInteractionListener: PlayPauseInteractionListener,
    modifier: Modifier
) {
    val initialValue = 0f
    val initCompleted = 0.2f
    val finalValue = 1f
    val aspectRatio = 1f

    val progress = remember { Animatable(initialValue) }
    var buttonState by remember { mutableStateOf(PlayPauseButtonState.OnPause.stateValue) }

    AnimatedImageView.AnimatedImage(
        id = R.raw.play_pause,
        progress = {
            progress.value
        },
        modifier = modifier
            .clickable {
                buttonState = if(buttonState == PlayPauseButtonState.OnResume.stateValue || buttonState == PlayPauseButtonState.OnInitCompleted.stateValue){
                    PlayPauseButtonState.OnPause.stateValue
                } else {
                    PlayPauseButtonState.OnResume.stateValue
                }
            }
            .aspectRatio(aspectRatio))

    if(buttonState != PlayPauseButtonState.OnPause.stateValue) {
        if (progress.value < initCompleted) {
            LaunchedEffect(progress, buttonState) {
                withContext(Dispatchers.Unconfined) {
                    if (buttonState == PlayPauseButtonState.OnResume.stateValue) {
                        progress.animateTo(
                            initCompleted,
                            animationSpec = tween(durationMillis = 500, easing = LinearEasing)
                        ) {
                            if (this.value == initCompleted) {
                                playButtonInteractionListener.onInitCompleted()
                                buttonState = PlayPauseButtonState.OnInitCompleted.stateValue
                            }
                        }
                    }
                }
            }
        } else {
            LaunchedEffect(progress, buttonState) {
                withContext(Dispatchers.Unconfined) {
                    progress.animateTo(
                        finalValue,
                        animationSpec = tween(
                            durationMillis = (durationInMillis.toFloat() * (1 - progress.value)).toInt(),
                            easing = LinearEasing
                        )
                    ) {
                        if (this.value == finalValue) {
                            CoroutineScope(Dispatchers.Unconfined).launch {
                                progress.snapTo(initialValue)
                                buttonState = PlayPauseButtonState.OnPause.stateValue
                            }
                        }
                    }
                }
            }
        }
    }
    else {
        LaunchedEffect(progress, buttonState) {
            withContext(Dispatchers.Unconfined) {
                progress.snapTo(progress.value)
            }
        }
    }
}

