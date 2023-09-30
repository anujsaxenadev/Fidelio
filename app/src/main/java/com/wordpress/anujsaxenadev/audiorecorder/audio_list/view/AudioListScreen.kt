package com.wordpress.anujsaxenadev.audiorecorder.audio_list.view

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.wordpress.anujsaxenadev.audiorecorder.audio_list.components.AudioItem
import com.wordpress.anujsaxenadev.audiorecorder.audio_list.view_model.AudioListViewModel

@Composable
fun AudioListScreen(
    viewModel: AudioListViewModel = hiltViewModel()) {

    val audioList = viewModel.audioListFlow.collectAsState().value
    LazyColumn(modifier = Modifier.padding(10.dp)) {
        items(audioList.size){
            AudioItem(audio = audioList[it])
        }
    }
}