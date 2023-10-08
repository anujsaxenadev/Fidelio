package com.wordpress.anujsaxenadev.audiorecorder.player.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.wordpress.anujsaxenadev.audiorecorder.player.repository.AudioPlayerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
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
    private val _durationFlow: MutableStateFlow<Int> = MutableStateFlow(-1)
    var durationFlow = _durationFlow.asStateFlow()

    init {
        getDuration()
    }

    private fun getDuration(){
        CoroutineScope(Dispatchers.IO).launch {
            val metaData = repository.initPlayer(fileName)
            _durationFlow.value = metaData?.duration ?: 0
        }
    }

    fun start(){
        CoroutineScope(Dispatchers.IO).launch {
            repository.play()
        }
    }

    private fun stop(){
        CoroutineScope(Dispatchers.IO).launch {
            repository.stop()
        }
    }

    fun pause(){
        CoroutineScope(Dispatchers.IO).launch {
            repository.pause()
        }
    }

    override fun onCleared() {
        stop()
        super.onCleared()
    }
}