package com.wordpress.anujsaxenadev.audiorecorder.core.components.play_pause_component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Forward10
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import com.wordpress.anujsaxenadev.audiorecorder.core.components.LocalImageView
import com.wordpress.anujsaxenadev.ui.theme.DSWhite

@Composable
fun Forward10Button(
    playerControlsType: PlayerControlsType,
    modifier: Modifier,
    playerControlsListener: PlayerControlsListener?) {
    if (playerControlsType == PlayerControlsType.Player) {
        LocalImageView.getLocalImage(
            imageVector = Icons.Filled.Forward10,
            colorFilter = ColorFilter.tint(DSWhite),
            modifier = modifier
                .clickable {
                    playerControlsListener?.on10SecForward()
                })
    } else {
        Spacer(
            modifier = modifier
        )
    }
}
