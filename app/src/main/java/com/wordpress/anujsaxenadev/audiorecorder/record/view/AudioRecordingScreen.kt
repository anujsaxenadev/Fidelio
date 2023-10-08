package com.wordpress.anujsaxenadev.audiorecorder.record.view

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.wordpress.anujsaxenadev.audiorecorder.core.components.GenericAudioPlayerView
import com.wordpress.anujsaxenadev.audiorecorder.core.components.GenericAudioPlayerViewType
import com.wordpress.anujsaxenadev.audiorecorder.core.components.play_pause_component.PlayerControls
import com.wordpress.anujsaxenadev.audiorecorder.core.components.play_pause_component.PlayerControlsType
import com.wordpress.anujsaxenadev.audiorecorder.core.components.play_pause_component.RecordControlsListener
import com.wordpress.anujsaxenadev.audiorecorder.record.viewmodel.AudioRecordingViewModel

@Composable
fun AudioRecordingScreen(navController: NavController){
    val viewModel: AudioRecordingViewModel = hiltViewModel()

    GenericAudioPlayerView(
        GenericAudioPlayerViewType.AudioRecord,
        navController){
        PlayerControls(PlayerControlsType.Record, recordControlsListener = object : RecordControlsListener {
            override fun onResume() {
                viewModel.startRecording()
            }

            override fun onPause() {
                viewModel.stopRecording()
            }
        })
    }
}