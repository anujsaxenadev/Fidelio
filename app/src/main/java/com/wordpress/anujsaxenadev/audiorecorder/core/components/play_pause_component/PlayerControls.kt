package com.wordpress.anujsaxenadev.audiorecorder.core.components.play_pause_component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics

@Composable
fun PlayerControls(
    playerControlsType: PlayerControlsType,
    playerControlsListener: PlayerControlsListener? = null,
    recordControlsListener: RecordControlsListener? = null,
    duration: Int? = null,
){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        val buttonModifier = Modifier
            .semantics {
                role = Role.Button
            }
        SkipPreviousButton(playerControlsType, Modifier
            .weight(playerControlsType.getPreviousButtonWeight()), playerControlsListener)

        Replay10Button(playerControlsType, Modifier
            .weight(playerControlsType.get10SecReplayButtonWeight()), playerControlsListener)

        CenterControlButton(
            duration = duration,
            modifier = buttonModifier.weight(playerControlsType.getPlayButtonWeight()),
            playerControlsType = playerControlsType,
            playerControlsListener = playerControlsListener,
            recordControlsListener = recordControlsListener
        )

        Forward10Button(playerControlsType, Modifier
            .weight(playerControlsType.get10SecForwardButtonWeight()), playerControlsListener)

        NextButton(playerControlsType, Modifier
            .weight(playerControlsType.getNextButtonWeight()), playerControlsListener)
    }
}

