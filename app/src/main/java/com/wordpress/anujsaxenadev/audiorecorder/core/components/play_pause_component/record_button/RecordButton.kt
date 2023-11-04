package com.wordpress.anujsaxenadev.audiorecorder.core.components.play_pause_component.record_button

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.wordpress.anujsaxenadev.audiorecorder.R
import com.wordpress.anujsaxenadev.ui.components.image.DSImage
import com.wordpress.anujsaxenadev.ui.components.image.ImageType
import com.wordpress.anujsaxenadev.ui.components.image.builders.AnimationIteration

@Composable
fun RecordButton(
    playButtonInteractionListener: RecordButtonInteractionListener,
    modifier: Modifier) {
    var buttonState by remember { mutableStateOf(RecordButtonState.OnStop.stateValue) }
    val aspectRatio = 1f

    when (buttonState) {
        RecordButtonState.OnStop.stateValue -> {
            DSImage(
                ImageType.AnimatedJson(
                    id = R.raw.record_button,
                    iterations = AnimationIteration.OneTime,
                    isPlaying = false,
                    modifier = modifier.clickable {
                        buttonState = RecordButtonState.OnRecord.stateValue
                        playButtonInteractionListener.onRecord()
                    }.aspectRatio(aspectRatio)
                )
            )
        }

        RecordButtonState.OnRecord.stateValue -> {
            DSImage(
                ImageType.AnimatedJson(
                    id = R.raw.record_button,
                    modifier = modifier.clickable {
                        buttonState = RecordButtonState.OnStop.stateValue
                        playButtonInteractionListener.onStop()
                    }.aspectRatio(aspectRatio)
                )
            )
        }
    }
}