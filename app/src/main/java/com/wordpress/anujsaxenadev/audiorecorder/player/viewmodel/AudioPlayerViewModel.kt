package com.wordpress.anujsaxenadev.audiorecorder.player.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.wordpress.anujsaxenadev.audiorecorder.player.repository.AudioPlayerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AudioPlayerViewModel @Inject constructor(
    private val repository: AudioPlayerRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel(){
    companion object{
        const val FILE_NAME_ID = "fileName"
    }
    private val fileName: String = checkNotNull(savedStateHandle[FILE_NAME_ID])

    fun start(){
        CoroutineScope(Dispatchers.IO).launch {
            repository.playFile(fileName)
        }
    }

    fun stop(){
        CoroutineScope(Dispatchers.IO).launch {
            repository.stop()
        }
    }

}