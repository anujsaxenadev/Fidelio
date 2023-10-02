package com.wordpress.anujsaxenadev.audiorecorder.record.viewmodel

import androidx.lifecycle.ViewModel
import com.wordpress.anujsaxenadev.audiorecorder.record.repository.AudioRecorderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AudioRecordingViewModel @Inject constructor(private val repository: AudioRecorderRepository) : ViewModel(){

    fun startRecording(){
        CoroutineScope(Dispatchers.IO).launch {
            repository.start()
        }
    }

    fun stopRecording(){
        CoroutineScope(Dispatchers.IO).launch {
            repository.stop()
        }
    }
}