package com.wordpress.anujsaxenadev.audiorecorder.player.components

sealed interface AudioImageTileType{
    object AnimatedImageJSON: AudioImageTileType
    object LocalImage: AudioImageTileType
}