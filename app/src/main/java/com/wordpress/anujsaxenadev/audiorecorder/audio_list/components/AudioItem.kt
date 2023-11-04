package com.wordpress.anujsaxenadev.audiorecorder.audio_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.wordpress.anujsaxenadev.audiorecorder.R
import com.wordpress.anujsaxenadev.audiorecorder.audio_list.models.AudioFile
import com.wordpress.anujsaxenadev.audiorecorder.core.components.LocalImageView
import com.wordpress.anujsaxenadev.audiorecorder.core.navigation.NavigationScreen
import com.wordpress.anujsaxenadev.ui.theme.DSGrey
import com.wordpress.anujsaxenadev.ui.theme.DSWhite
import com.wordpress.anujsaxenadev.ui.theme.Dimen_24adp
import com.wordpress.anujsaxenadev.ui.theme.Dimen_4adp
import com.wordpress.anujsaxenadev.ui.theme.Dimen_50adp

@Composable
fun AudioItem (navController: NavController, audio: AudioFile){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimen_4adp)
            .clickable {
                navController.navigate(NavigationScreen.AudioPlayerScreen.route + "/${audio.fileName}")
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()) {

            Box(modifier = Modifier.weight(2f)) {
                LocalImageView.getLocalImage(
                    id = R.mipmap.audio_icon,
                    modifier = Modifier
                        .height(
                            Dimen_50adp
                        )
                        .aspectRatio(1f)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(10f),
                verticalArrangement = Arrangement.Top) {
                Text(
                    text = audio.fileName,
                    fontSize = 14.sp,
                    color = DSWhite,
                    fontWeight = FontWeight(500))
                Text(text = audio.fileName,
                    fontSize = 10.sp,
                    color = DSGrey,
                    fontWeight = FontWeight(400))
            }

            Box(modifier = Modifier.weight(1f)) {
                LocalImageView.getLocalImage(
                    imageVector = Icons.Filled.PlayArrow,
                    colorFilter = ColorFilter.tint(DSWhite),
                    modifier = Modifier
                        .height(
                            Dimen_24adp
                        )
                        .aspectRatio(1f)
                )
            }
        }
    }
}