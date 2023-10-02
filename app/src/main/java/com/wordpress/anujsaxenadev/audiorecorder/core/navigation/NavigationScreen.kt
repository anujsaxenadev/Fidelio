package com.wordpress.anujsaxenadev.audiorecorder.core.navigation

sealed class NavigationScreen(val route: String) {
    object AudioListScreen: NavigationScreen("AudioListScreen")
    object MainScreen: NavigationScreen("MainScreen")
    object AudioPlayerScreen: NavigationScreen("AudioPlayerScreen")
}