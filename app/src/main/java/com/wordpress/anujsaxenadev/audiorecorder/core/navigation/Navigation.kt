package com.wordpress.anujsaxenadev.audiorecorder.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.wordpress.anujsaxenadev.audiorecorder.audio_list.view.AudioListScreen
import com.wordpress.anujsaxenadev.audiorecorder.player.view.AudioPlayerScreen
import com.wordpress.anujsaxenadev.audiorecorder.record.view.AudioRecordingScreen
import com.wordpress.anujsaxenadev.audiorecorder.splash.view.SplashScreen

@Composable
fun Navigation (){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationScreen.MainScreen) {
        composable<NavigationScreen.MainScreen>{
            SplashScreen(navController)
        }
        composable<NavigationScreen.AudioRecordingScreen>{
            AudioRecordingScreen(navController)
        }
        composable<NavigationScreen.AudioPlayerScreen>{
            AudioPlayerScreen(navController, it.toRoute<NavigationScreen.AudioPlayerScreen>().fileName)
        }
        composable<NavigationScreen.AudioListScreen>{
            AudioListScreen(navController)
        }
    }
}