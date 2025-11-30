package com.wordpress.anujsaxenadev.audiorecorder.audio_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import com.wordpress.anujsaxenadev.audiorecorder.R
import com.wordpress.anujsaxenadev.audiorecorder.audio_list.models.AudioFile
import com.wordpress.anujsaxenadev.audiorecorder.core.navigation.NavigationScreen
import com.wordpress.anujsaxenadev.ui.components.image.DSImage
import com.wordpress.anujsaxenadev.ui.components.image.ImageType
import com.wordpress.anujsaxenadev.ui.theme.Dimen_24adp
import com.wordpress.anujsaxenadev.ui.theme.Dimen_50adp
import com.wordpress.anujsaxenadev.ui.theme.Dimen_70adp

@Composable
fun AudioItem(navController: NavController, audio: AudioFile) {
    ListItem(
        headlineContent = { Text(audio.fileName) },
        leadingContent = {
            DSImage(
                ImageType.Resource(
                    R.mipmap.audio_icon,
                    modifier = Modifier.height(Dimen_50adp)
                )
            )
        },
        trailingContent = {
            DSImage(
                ImageType.Vector(
                    Icons.Default.PlayArrow,
                    modifier = Modifier.height(Dimen_24adp)
                )
            )
        },
        modifier = Modifier.clickable {
            navController.navigate(NavigationScreen.AudioPlayerScreen(audio.fileName))
        }
    )
}