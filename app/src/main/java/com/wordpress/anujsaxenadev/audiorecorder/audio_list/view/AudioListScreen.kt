package com.wordpress.anujsaxenadev.audiorecorder.audio_list.view

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.wordpress.anujsaxenadev.audiorecorder.audio_list.components.AudioItem
import com.wordpress.anujsaxenadev.audiorecorder.audio_list.components.AudioListHeader
import com.wordpress.anujsaxenadev.audiorecorder.audio_list.view_model.AudioListViewModel
import com.wordpress.anujsaxenadev.ui.theme.Dimen_10adp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AudioListScreen(
    navController: NavController,
    viewModel: AudioListViewModel = hiltViewModel()
) {
    val audioList = viewModel.audioListFlow.collectAsState().value
    Scaffold(
        topBar = {
            TopAppBar(title = { AudioListHeader() })
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues).padding(Dimen_10adp)) {
            items(audioList.size) {
                AudioItem(navController, audio = audioList[it])
            }
        }
    }
}