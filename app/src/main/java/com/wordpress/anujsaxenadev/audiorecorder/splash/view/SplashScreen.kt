package com.wordpress.anujsaxenadev.audiorecorder.splash.view

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.wordpress.anujsaxenadev.audiorecorder.R
import com.wordpress.anujsaxenadev.audiorecorder.core.components.AnimatedImageView
import com.wordpress.anujsaxenadev.audiorecorder.core.navigation.NavigationScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun SplashScreen(navController: NavController){

    val progress = remember { Animatable(0f) }
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()){
            AnimatedImageView.AnimatedImage(
                id = R.raw.splash_animation,
                progress = {
                    progress.value
                })

            LaunchedEffect(progress) {
                withContext(Dispatchers.Unconfined) {
                    progress.animateTo(
                        1f,
                        animationSpec = tween(durationMillis = 3500, easing = LinearEasing)
                    ) {
                        if (this.value == 1f) {
                            navController.navigate(NavigationScreen.AudioRecordingScreen.route)
                        }
                    }
                }
            }
        }
    }
}



