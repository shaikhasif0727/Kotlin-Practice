@file:OptIn(ExperimentalAnimationApi::class)

package com.gaming.kotlinpracticeproject

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedContentLambdaTargetStateParameter")
@Composable
fun AnimatedContentExample(modifier: Modifier = Modifier) {
    var count by remember { mutableIntStateOf(0) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { count-- }) {
            Text(text = "Decrease count")
        }

        AnimatedContent(
            targetState = count,
            transitionSpec = {
                if(targetState > initialState){
                   slideInVertically(animationSpec = tween(durationMillis = 300)) { fullHeight -> fullHeight } + fadeIn(tween(durationMillis = 300)) with slideOutVertically(tween(durationMillis = 300)) { fullHeight -> -fullHeight }
                } else {
                    slideInVertically(tween(durationMillis = 300)) { fullHeight -> -fullHeight } + fadeIn(tween(durationMillis = 300)) with slideOutVertically(tween(durationMillis = 300)) { fullHeight -> fullHeight  }
                }.using(SizeTransform(clip = true))
            },
            label = "",
            content = {
                Box(modifier = Modifier.size(180.dp), contentAlignment = Alignment.Center) {
                    Text(text = "$count", style = MaterialTheme.typography.headlineLarge)
                }
            }
        )

        Button(onClick = { count++ }) {
            Text(text = "Increase count")
        }
    }

}