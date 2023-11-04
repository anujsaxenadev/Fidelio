package com.wordpress.anujsaxenadev.audiorecorder.core.components.play_pause_component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import com.wordpress.anujsaxenadev.audiorecorder.core.components.LocalImageView
import com.wordpress.anujsaxenadev.ui.theme.DSWhite

@Composable
fun SkipPreviousButton(
    playerControlsType: PlayerControlsType,
    modifier: Modifier,
    playerControlsListener: PlayerControlsListener?){
    if(playerControlsType == PlayerControlsType.Player) {
        LocalImageView.getLocalImage(
            imageVector = Icons.Filled.SkipPrevious,
            colorFilter = ColorFilter.tint(DSWhite),
            modifier = modifier
                .clickable {
                    playerControlsListener?.onPrevious()
                })
    } else {
        Spacer(
            modifier = modifier)
    }
}