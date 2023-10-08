package com.wordpress.anujsaxenadev.audiorecorder.player.view

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.wordpress.anujsaxenadev.audiorecorder.core.components.GenericAudioPlayerView
import com.wordpress.anujsaxenadev.audiorecorder.core.components.GenericAudioPlayerViewType
import com.wordpress.anujsaxenadev.audiorecorder.core.components.play_pause_component.PlayerControls
import com.wordpress.anujsaxenadev.audiorecorder.core.components.play_pause_component.PlayerControlsListener
import com.wordpress.anujsaxenadev.audiorecorder.core.components.play_pause_component.PlayerControlsType
import com.wordpress.anujsaxenadev.audiorecorder.player.viewmodel.AudioPlayerViewModel

@Composable
fun AudioPlayerScreen(navController: NavController){
    val viewModel: AudioPlayerViewModel = hiltViewModel()
    GenericAudioPlayerView(
        GenericAudioPlayerViewType.AudioPlayer,
        navController){
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