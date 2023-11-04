package com.wordpress.anujsaxenadev.audiorecorder.player.view

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.wordpress.anujsaxenadev.audiorecorder.R
import com.wordpress.anujsaxenadev.audiorecorder.core.components.GenericAudioPlayerView
import com.wordpress.anujsaxenadev.audiorecorder.core.components.GenericAudioPlayerViewType
import com.wordpress.anujsaxenadev.audiorecorder.core.components.GradientBackgroundComponent
import com.wordpress.anujsaxenadev.audiorecorder.core.components.play_pause_component.PlayerControls
import com.wordpress.anujsaxenadev.audiorecorder.core.components.play_pause_component.PlayerControlsListener
import com.wordpress.anujsaxenadev.audiorecorder.core.components.play_pause_component.PlayerControlsType
import com.wordpress.anujsaxenadev.audiorecorder.player.viewmodel.AudioPlayerViewModel
import com.wordpress.anujsaxenadev.ui.components.image.DSImage
import com.wordpress.anujsaxenadev.ui.components.image.ImageType

@Composable
fun AudioPlayerScreen(navController: NavController){
    val viewModel: AudioPlayerViewModel = hiltViewModel()

    when (val duration = viewModel.durationFlow.collectAsState().value) {
        -1 -> {
            GradientBackgroundComponent {
                DSImage(
                    ImageType.AnimatedJson(
                        id = R.raw.loader,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center)
                            .aspectRatio(1f)
                    )
                )
            }
        }
        0 -> {
            // Error
        }
        else -> {
            GenericAudioPlayerView(
                GenericAudioPlayerViewType.AudioPlayer,
                navController) {
                PlayerControls(
                    PlayerControlsType.Player,
                    duration = duration,
                    playerControlsListener = object : PlayerControlsListener {
                        override fun onPlay() {
                            viewModel.start()
                        }

                        override fun onPause() {
                            viewModel.pause()
                        }

                        override fun onNext() {

                        }

                        override fun onPrevious() {

                        }

                        override fun on10SecReplay() {

                        }

                        override fun on10SecForward() {

                        }
                    }
                )
            }
        }
    }
}

