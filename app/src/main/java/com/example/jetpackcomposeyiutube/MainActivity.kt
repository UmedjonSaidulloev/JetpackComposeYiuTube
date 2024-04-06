package com.example.jetpackcomposeyiutube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.jetpackcomposeyiutube.screens.MainCard
import com.example.jetpackcomposeyiutube.screens.TabLayout
import com.example.jetpackcomposeyiutube.ui.theme.JetpackComposeYiuTubeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeYiuTubeTheme {
                Image(
                    painter = painterResource(
                        id = R.drawable.asosi
                    ),
                    contentDescription = "im1",
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(0.5f),
                    contentScale = ContentScale.FillBounds,
                )
                Column {
                    MainCard()
                    TabLayout()
                }
            }
        }
    }
}
