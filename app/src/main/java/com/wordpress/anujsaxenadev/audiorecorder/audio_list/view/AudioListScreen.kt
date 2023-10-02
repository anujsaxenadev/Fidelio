package com.wordpress.anujsaxenadev.audiorecorder.audio_list.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.wordpress.anujsaxenadev.audiorecorder.audio_list.components.AudioItem
import com.wordpress.anujsaxenadev.audiorecorder.audio_list.components.AudioListHeader
import com.wordpress.anujsaxenadev.audiorecorder.audio_list.view_model.AudioListViewModel
import com.wordpress.anujsaxenadev.audiorecorder.ui.theme.DSGradientEnd
import com.wordpress.anujsaxenadev.audiorecorder.ui.theme.DSGradientStart
import com.wordpress.anujsaxenadev.audiorecorder.ui.theme.Dimen_10adp

@Composable
fun AudioListScreen(
    navController: NavController,
    viewModel: AudioListViewModel = hiltViewModel()) {


    val audioList = viewModel.audioListFlow.collectAsState().value
    Box(modifier = Modifier
        .background(
            brush = Brush.linearGradient(
                colors = listOf(
                    DSGradientEnd,
                    DSGradientStart
                )
            )
        )) {
        LazyColumn(modifier = Modifier.padding(Dimen_10adp)) {
            items(audioList.size + 1) {
                if(it == 0){
                    AudioListHeader()
                }
                else {
                    AudioItem(navController, audio = audioList[it - 1])
                }
            }
        }
    }
}