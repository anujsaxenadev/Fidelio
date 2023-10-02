package com.wordpress.anujsaxenadev.audiorecorder.core.navigation

sealed class NavigationScreen(val route: String) {
    object MainScreen: NavigationScreen("MainScreen")
    object AudioPlayerScreen: NavigationScreen("AudioPlayerScreen")
    object AudioRecordingScreen: NavigationScreen("AudioRecordingScreen")
    object AudioListScreen: NavigationScreen("AudioListScreen")
}