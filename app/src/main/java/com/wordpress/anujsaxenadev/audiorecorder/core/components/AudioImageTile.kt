package com.wordpress.anujsaxenadev.audiorecorder.core.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.neu
import com.wordpress.anujsaxenadev.audiorecorder.ui.theme.DSGradientEnd
import com.wordpress.anujsaxenadev.audiorecorder.ui.theme.DSGradientStart
import com.wordpress.anujsaxenadev.audiorecorder.ui.theme.DSWhite
import com.wordpress.anujsaxenadev.audiorecorder.ui.theme.Dimen_10adp
import com.wordpress.anujsaxenadev.audiorecorder.ui.theme.Dimen_50adp

@Composable
fun AudioImageTile(
    id: Int,
    audioImageTileType: AudioImageTileType
){
    val roundedRadius = Dimen_10adp
    Card(
        colors = CardDefaults.cardColors(
            containerColor = DSWhite
        ),
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .neu(
                lightShadowColor = DSGradientEnd,
                darkShadowColor = DSGradientStart,
                shadowElevation = Dimen_50adp,
                lightSource = LightSource.LEFT_TOP,
            ),
        shape = RoundedCornerShape(roundedRadius),
    ){
        val modifier = Modifier
            .aspectRatio(1f)
            .clip(RoundedCornerShape(roundedRadius))
        when(audioImageTileType){
            AudioImageTileType.AnimatedImageJSON -> {
                AnimatedImageView.AnimatedImage(
                    id = id,
                    modifier = modifier)
            }
            AudioImageTileType.LocalImage -> {
                LocalImageView.getLocalImage(
                    id,
                    modifier = modifier)
            }
        }
    }
}

sealed interface AudioImageTileType{
    object AnimatedImageJSON: AudioImageTileType
    object LocalImage: AudioImageTileType
}