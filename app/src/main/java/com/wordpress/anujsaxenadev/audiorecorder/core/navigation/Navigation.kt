package com.wordpress.anujsaxenadev.audiorecorder.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wordpress.anujsaxenadev.audiorecorder.audio_list.view.AudioListScreen

@Composable
fun Navigation (){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationScreen.MainScreen.route) {
        composable(route = NavigationScreen.MainScreen.route){
            AudioListScreen()
        }
    }
}