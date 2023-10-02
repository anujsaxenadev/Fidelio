package com.wordpress.anujsaxenadev.audiorecorder.core.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Forward10
import androidx.compose.material.icons.filled.Replay10
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import com.wordpress.anujsaxenadev.audiorecorder.ui.theme.DSPrimary

@Composable
fun PlayerControls(
    playerControlsType: PlayerControlsType,
    playerControlsListener: PlayerControlsListener? = null,
    recordControlsListener: RecordControlsListener? = null
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

        if(playerControlsType == PlayerControlsType.Player) {
            LocalImageView.getLocalImage(
                imageVector = Icons.Filled.SkipPrevious,
                colorFilter = ColorFilter.tint(DSPrimary),
                modifier = buttonModifier
                    .weight(playerControlsType.getPreviousButtonWeight())
                    .clickable {
                        playerControlsListener?.onPrevious()
                    })
        } else {
            Spacer(
                modifier = Modifier
                    .weight(playerControlsType.getPreviousButtonWeight()))
        }

        if(playerControlsType == PlayerControlsType.Player) {
            LocalImageView.getLocalImage(
                imageVector = Icons.Filled.Replay10,
                colorFilter = ColorFilter.tint(DSPrimary),
                modifier = buttonModifier
                    .weight(playerControlsType.get10SecReplayButtonWeight())
                    .clickable {
                        playerControlsListener?.on10SecReplay()
                    })
        } else {
            Spacer(
                modifier = Modifier
                    .weight(playerControlsType.get10SecReplayButtonWeight()))
        }

        PlayPauseButton(object : OnPlayButtonInteractionListener {
            override fun onOn() {
                playerControlsListener?.onPlay()
                recordControlsListener?.onPlay()
            }

            override fun onOff() {
                playerControlsListener?.onPause()
                recordControlsListener?.onPause()
            }
        }, modifier = buttonModifier.weight(playerControlsType.getPlayButtonWeight()))

        if(playerControlsType == PlayerControlsType.Player) {
            LocalImageView.getLocalImage(
                imageVector = Icons.Filled.Forward10,
                colorFilter = ColorFilter.tint(DSPrimary),
                modifier = buttonModifier
                    .weight(playerControlsType.get10SecForwardButtonWeight())
                    .clickable {
                        playerControlsListener?.on10SecForward()
                    })
        } else {
            Spacer(
                modifier = Modifier
                    .weight(playerControlsType.get10SecForwardButtonWeight()))
        }

        if(playerControlsType == PlayerControlsType.Player) {
            LocalImageView.getLocalImage(
                imageVector = Icons.Filled.SkipNext,
                colorFilter = ColorFilter.tint(DSPrimary),
                modifier = buttonModifier
                    .weight(playerControlsType.getNextButtonWeight())
                    .clickable {
                        playerControlsListener?.onNext()
                    })
        } else {
            Spacer(
                modifier = Modifier
                    .weight(playerControlsType.getNextButtonWeight()))
        }
    }
}

sealed interface PlayerControlsType{
    fun getPlayButtonWeight(): Float = 3F
    fun getNextButtonWeight(): Float = 1F
    fun getPreviousButtonWeight(): Float = 1F
    fun get10SecReplayButtonWeight(): Float = 1F
    fun get10SecForwardButtonWeight(): Float = 1F

    object Record: PlayerControlsType
    object Player: PlayerControlsType
}

interface PlayerControlsListener{
    fun onPlay()
    fun onPause()
    fun onNext()
    fun onPrevious()
    fun on10SecReplay()
    fun on10SecForward()
}

interface RecordControlsListener{
    fun onPlay()
    fun onPause()
}