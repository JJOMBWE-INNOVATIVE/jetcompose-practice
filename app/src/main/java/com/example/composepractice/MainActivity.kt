package com.example.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.composepractice.ui.theme.MyCustomCard
import com.example.composepractice.ui.theme.Publisher


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.8f)),
                contentAlignment = Alignment.Center

           ){
                MyCustomCard(
                    modifier = Modifier.fillMaxWidth(0.8f),
                    image = R.drawable.elephant,
                    title = "Elephant Very Big",
                    text = "Elephant is very big animal in the world the greatest of them all and the biggest in the world",
                    publisher = Publisher(
                        name = "JJOMBWE NATHAN",
                        image = R.drawable.resource_new,
                        job = "Android Developer"
                    )
                )
            }

        }
    }
}






