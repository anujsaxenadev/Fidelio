package com.wordpress.anujsaxenadev.audiorecorder.record.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wordpress.anujsaxenadev.audiorecorder.record.repository.AudioRecorderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AudioRecordingViewModel @Inject constructor(private val repository: AudioRecorderRepository) : ViewModel(){

    fun startRecording(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.start()
        }
    }

    fun stopRecording(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.stop()
        }
    }
}