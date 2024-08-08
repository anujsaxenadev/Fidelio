package com.wordpress.anujsaxenadev.audiorecorder.player.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wordpress.anujsaxenadev.audiorecorder.player.repository.AudioPlayerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AudioPlayerViewModel @Inject constructor(
    private val repository: AudioPlayerRepository
) : ViewModel(){

    private val _durationFlow: MutableStateFlow<Int> = MutableStateFlow(-1)
    var durationFlow = _durationFlow.asStateFlow()

    fun getDuration(fileName: String){
        viewModelScope.launch(Dispatchers.IO) {
            val metaData = repository.initPlayer(fileName)
            _durationFlow.value = metaData.duration
        }
    }

    fun start(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.play()
        }
    }

    private fun stop(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.stop()
        }
    }

    fun pause(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.pause()
        }
    }

    override fun onCleared() {
        stop()
        super.onCleared()
    }
}