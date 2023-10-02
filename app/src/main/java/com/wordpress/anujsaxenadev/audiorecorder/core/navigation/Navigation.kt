package com.wordpress.anujsaxenadev.audiorecorder.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wordpress.anujsaxenadev.audiorecorder.audio_list.view.AudioListScreen
import com.wordpress.anujsaxenadev.audiorecorder.player.view.AudioPlayerScreen
import com.wordpress.anujsaxenadev.audiorecorder.player.viewmodel.AudioPlayerViewModel
import com.wordpress.anujsaxenadev.audiorecorder.record.view.AudioRecordingScreen

@Composable
fun Navigation (){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationScreen.MainScreen.route) {
        composable(route = NavigationScreen.MainScreen.route){
            AudioRecordingScreen(navController)
        }
        composable(route = NavigationScreen.AudioPlayerScreen.route + "/{${AudioPlayerViewModel.FILE_NAME_ID}}"){
            AudioPlayerScreen(navController)
        }
        composable(route = NavigationScreen.AudioListScreen.route){
            AudioListScreen(navController)
        }

    }
}