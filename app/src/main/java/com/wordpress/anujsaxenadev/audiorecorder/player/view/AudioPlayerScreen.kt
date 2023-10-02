package com.wordpress.anujsaxenadev.audiorecorder.player.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.wordpress.anujsaxenadev.audiorecorder.R
import com.wordpress.anujsaxenadev.audiorecorder.core.components.AudioImageTile
import com.wordpress.anujsaxenadev.audiorecorder.core.components.AudioImageTileType
import com.wordpress.anujsaxenadev.audiorecorder.core.components.LocalImageView
import com.wordpress.anujsaxenadev.audiorecorder.core.components.play_pause_component.PlayerControls
import com.wordpress.anujsaxenadev.audiorecorder.core.components.play_pause_component.PlayerControlsListener
import com.wordpress.anujsaxenadev.audiorecorder.core.components.play_pause_component.PlayerControlsType
import com.wordpress.anujsaxenadev.audiorecorder.core.navigation.NavigationScreen
import com.wordpress.anujsaxenadev.audiorecorder.player.viewmodel.AudioPlayerViewModel
import com.wordpress.anujsaxenadev.audiorecorder.ui.theme.DSGradientEnd
import com.wordpress.anujsaxenadev.audiorecorder.ui.theme.DSGradientStart
import com.wordpress.anujsaxenadev.audiorecorder.ui.theme.DSWhite
import com.wordpress.anujsaxenadev.audiorecorder.ui.theme.Dimen_100adp
import com.wordpress.anujsaxenadev.audiorecorder.ui.theme.Dimen_10adp
import com.wordpress.anujsaxenadev.audiorecorder.ui.theme.Dimen_16adp
import com.wordpress.anujsaxenadev.audiorecorder.ui.theme.Dimen_70adp

@Composable
fun AudioPlayerScreen(navController: NavController){
    val viewModel: AudioPlayerViewModel = hiltViewModel()

    Box(modifier = Modifier
        .background(
            brush = Brush.linearGradient(
                colors = listOf(
                    DSGradientEnd,
                    DSGradientStart
                )
            )
        )
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .padding(horizontal = Dimen_16adp)
                .fillMaxHeight()
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(top = Dimen_16adp),
                contentAlignment = Alignment.TopEnd){
                LocalImageView.getLocalImage(
                    imageVector = Icons.AutoMirrored.Filled.List,
                    colorFilter = ColorFilter.tint(DSWhite),
                    modifier = Modifier
                        .padding(Dimen_10adp)
                        .clickable {
                            navController.navigate(NavigationScreen.AudioListScreen.route)
                        }
                )
            }
            Spacer(modifier = Modifier.height(Dimen_70adp))
            AudioImageTile(R.raw.record_tile_image, AudioImageTileType.AnimatedImageJSON)
            Spacer(modifier = Modifier.height(Dimen_100adp))
            PlayerControls(
                PlayerControlsType.Player,
                duration = 10000,
                playerControlsListener = object : PlayerControlsListener {
                override fun onPlay() {
                    viewModel.start()
                }

                override fun onPause() {
                    viewModel.stop()
                }

                override fun onNext() {

                }

                override fun onPrevious() {

                }

                override fun on10SecReplay() {

                }

                override fun on10SecForward() {

                }
            })
        }
    }
}