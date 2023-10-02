package com.wordpress.anujsaxenadev.audiorecorder.record.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.hilt.navigation.compose.hiltViewModel
import com.wordpress.anujsaxenadev.audiorecorder.R
import com.wordpress.anujsaxenadev.audiorecorder.core.components.AudioImageTile
import com.wordpress.anujsaxenadev.audiorecorder.core.components.AudioImageTileType
import com.wordpress.anujsaxenadev.audiorecorder.core.components.LocalImageView
import com.wordpress.anujsaxenadev.audiorecorder.core.components.PlayerControls
import com.wordpress.anujsaxenadev.audiorecorder.core.components.PlayerControlsType
import com.wordpress.anujsaxenadev.audiorecorder.core.components.RecordControlsListener
import com.wordpress.anujsaxenadev.audiorecorder.record.viewmodel.AudioRecordingViewModel
import com.wordpress.anujsaxenadev.audiorecorder.ui.theme.DSPrimary
import com.wordpress.anujsaxenadev.audiorecorder.ui.theme.Dimen_100adp
import com.wordpress.anujsaxenadev.audiorecorder.ui.theme.Dimen_16adp
import com.wordpress.anujsaxenadev.audiorecorder.ui.theme.Dimen_4adp
import com.wordpress.anujsaxenadev.audiorecorder.ui.theme.Dimen_70adp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AudioRecordingScreen(){
    val viewModel: AudioRecordingViewModel = hiltViewModel()
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(),
                title = {},
                actions = {
                    IconButton(onClick = {

                    }) {
                        LocalImageView.getLocalImage(
                            imageVector = Icons.AutoMirrored.Filled.List,
                            colorFilter = ColorFilter.tint(DSPrimary),
                            modifier = Modifier.padding(Dimen_4adp)
                        )
                    }
                }
            )
        },
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = Dimen_16adp)
                .fillMaxHeight()
        ) {
            Spacer(modifier = Modifier.height(Dimen_70adp))
            AudioImageTile(R.raw.record_tile_image, AudioImageTileType.AnimatedImageJSON)
            Spacer(modifier = Modifier.height(Dimen_100adp))
            PlayerControls(PlayerControlsType.Record, recordControlsListener = object : RecordControlsListener{
                override fun onPlay() {
                    viewModel.startRecording()
                }

                override fun onPause() {
                    viewModel.stopRecording()
                }
            })
        }
    }
}