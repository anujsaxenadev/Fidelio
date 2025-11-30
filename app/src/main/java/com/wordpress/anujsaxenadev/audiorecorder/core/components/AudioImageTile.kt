package com.wordpress.anujsaxenadev.audiorecorder.core.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.wordpress.anujsaxenadev.ui.components.image.DSImage
import com.wordpress.anujsaxenadev.ui.components.image.ImageType
import com.wordpress.anujsaxenadev.ui.theme.DSWhite
import com.wordpress.anujsaxenadev.ui.theme.Dimen_10adp

@Composable
fun AudioImageTile(
    id: Int,
    audioImageTileType: AudioImageTileType
){
    val shape = RoundedCornerShape(Dimen_10adp)
    AnimatedBorderCard(
        modifier = Modifier
            .fillMaxWidth(0.8f),
        shape = shape,
    ){
        Card(
            colors = CardDefaults.cardColors(
                containerColor = DSWhite
            ),
            shape = shape
        ){
            val modifier = Modifier
                .aspectRatio(1f)
                .clip(shape)
            when(audioImageTileType){
                AudioImageTileType.AnimatedImageJSON -> {
                    DSImage(
                        ImageType.AnimatedJson(
                            id = id,
                            modifier = modifier
                        )
                    )
                }
                AudioImageTileType.LocalImage -> {
                    DSImage(
                        ImageType.Resource(
                            id,
                            modifier = modifier
                        )
                    )
                }
            }
        }
    }

}

sealed interface AudioImageTileType{
    object AnimatedImageJSON: AudioImageTileType
    object LocalImage: AudioImageTileType
}
