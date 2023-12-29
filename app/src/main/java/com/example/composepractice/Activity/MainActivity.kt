package com.example.composepractice.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.composepractice.Screens.WelcomeScreen
import com.example.composepractice.ui.theme.ComposePracticeTheme


class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

          ComposePracticeTheme {
              WelcomeScreen()
               // LoginScreen()
             // RegisterScreen()



          }
        }
    }
}






