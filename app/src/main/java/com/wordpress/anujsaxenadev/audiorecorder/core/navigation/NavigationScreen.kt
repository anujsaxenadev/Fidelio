package com.wordpress.anujsaxenadev.audiorecorder.core.navigation

import kotlinx.serialization.Serializable

sealed interface NavigationScreen {

    @Serializable
    data object MainScreen: NavigationScreen

    @Serializable
    data class AudioPlayerScreen(val fileName: String): NavigationScreen

    @Serializable
    data object AudioRecordingScreen: NavigationScreen

    @Serializable
    data object AudioListScreen: NavigationScreen
}