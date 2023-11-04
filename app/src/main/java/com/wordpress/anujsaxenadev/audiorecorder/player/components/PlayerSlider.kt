package com.wordpress.anujsaxenadev.audiorecorder.player.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.wordpress.anujsaxenadev.ui.theme.DSPrimary

@Composable
fun PlayerSlider() {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Slider(
//            value = currentMinutes.value!!.toFloat(),
            value = 2F,
            onValueChange = {},
            valueRange = 0f..5f,
            colors = SliderDefaults.colors(
                thumbColor = DSPrimary,
                activeTrackColor = DSPrimary
            )
        )
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "1 s",
                color = DSPrimary
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "5 s",
                color = DSPrimary
            )
        }
    }
}