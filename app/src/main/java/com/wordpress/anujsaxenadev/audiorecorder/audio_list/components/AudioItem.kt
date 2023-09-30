package com.wordpress.anujsaxenadev.audiorecorder.audio_list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wordpress.anujsaxenadev.audiorecorder.audio_list.models.AudioFile

@Composable
fun AudioItem (audio: AudioFile){
    Box(modifier = Modifier.fillMaxWidth().padding(10.dp))
    Text(audio.fileName)
}