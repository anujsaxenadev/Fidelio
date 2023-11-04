package com.wordpress.anujsaxenadev.audiorecorder.core.components.play_pause_component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Replay10
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import com.wordpress.anujsaxenadev.ui.components.image.DSImage
import com.wordpress.anujsaxenadev.ui.components.image.ImageType
import com.wordpress.anujsaxenadev.ui.theme.DSWhite

@Composable
fun Replay10Button(
    playerControlsType: PlayerControlsType,
    modifier: Modifier,
    playerControlsListener: PlayerControlsListener?){
    if(playerControlsType == PlayerControlsType.Player) {
        if(playerControlsType == PlayerControlsType.Player) {
            DSImage(
                ImageType.Vector(
                    Icons.Filled.Replay10,
                    modifier = modifier
                        .clickable {
                            playerControlsListener?.on10SecReplay()
                        },
                    colorFilter = ColorFilter.tint(DSWhite)
                )
            )
        }
    } else {
        Spacer(
            modifier = modifier)
    }
}