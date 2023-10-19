package com.wordpress.anujsaxenadev.audiorecorder.audio_list.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wordpress.anujsaxenadev.audiorecorder.audio_list.models.AudioFile
import com.wordpress.anujsaxenadev.audiorecorder.audio_list.repository.impl.AudioListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AudioListViewModel @Inject constructor(private val repository: AudioListRepository): ViewModel() {
    private val _audioListFlow: MutableStateFlow<ArrayList<AudioFile>> = MutableStateFlow(ArrayList())
    val audioListFlow = _audioListFlow.asStateFlow()

    init {
        getAudioList()
    }

    private fun getAudioList() {
        viewModelScope.launch(Dispatchers.IO) {
            _audioListFlow.value = repository.getAudioList()
        }
    }
}