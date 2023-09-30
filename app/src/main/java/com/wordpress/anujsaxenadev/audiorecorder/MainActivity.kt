package com.wordpress.anujsaxenadev.audiorecorder

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import com.wordpress.anujsaxenadev.audiorecorder.core.file_manager.impl.AndroidFileManager
import com.wordpress.anujsaxenadev.audiorecorder.core.file_manager.impl.FileManager
import com.wordpress.anujsaxenadev.audiorecorder.core.navigation.Navigation
import com.wordpress.anujsaxenadev.audiorecorder.player.repository.AndroidAudioPlayer
import com.wordpress.anujsaxenadev.audiorecorder.player.repository.AudioPlayer
import com.wordpress.anujsaxenadev.audiorecorder.record.repository.AndroidAudioRecorder
import com.wordpress.anujsaxenadev.audiorecorder.record.repository.AudioRecorder
import com.wordpress.anujsaxenadev.audiorecorder.ui.theme.FidelioTheme
import dagger.hilt.android.AndroidEntryPoint
import java.io.File

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

//    private var audioFile: File? = null

//    private val recorder: AudioRecorder by lazy{
//        AndroidAudioRecorder(applicationContext)
//    }
//
//    private val player: AudioPlayer by lazy {
//        AndroidAudioPlayer(applicationContext)
//    }

//    private val fileManager: FileManager by lazy {
//        AndroidFileManager(applicationContext)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCompat.requestPermissions(
            this, arrayOf(Manifest.permission.RECORD_AUDIO),
            0
        )
        setContent {
            FidelioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()

//                    LazyColumn{
//                        itemsIndexed(fileManager.getListOfRecordedAudio()){ _, string ->
//                            Text(text = string)
//                        }
//                    }
//                    Column (
//                        modifier = Modifier.fillMaxSize(),
//                        verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally){
//                        Button(onClick = {
//                            val a = File(filesDir, "audio.mp3").also {
//                                recorder.start(it)
//                                audioFile = it
//                            }
//                        }) {
//                            Text(text = "Start Recording")
//                        }
//
//                        Button(onClick = {
//                            recorder.stop()
//                        }) {
//                            Text(text = "Stop Recording")
//                        }
//
//                        Button(onClick = {
//                            player.playFile(audioFile ?: return@Button)
//                        }) {
//                            Text(text = "Play")
//                        }
//
//                        Button(onClick = {
//                            player.stop()
//                        }) {
//                            Text(text = "Play")
//                        }
//                    }
                }
            }
        }
    }
}