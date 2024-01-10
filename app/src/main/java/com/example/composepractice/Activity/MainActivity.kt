package com.example.composepractice.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composepractice.Navigation.SetUpNavigation
import com.example.composepractice.Screens.ActivityScreen
import com.example.composepractice.Screens.HomeScreen
import com.example.composepractice.Screens.HospitalInfo
import com.example.composepractice.Screens.WelcomeScreen
import com.example.composepractice.ui.theme.ComposePracticeTheme


class MainActivity : ComponentActivity() {
     lateinit var  navController: NavHostController
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

          ComposePracticeTheme {
              navController = rememberNavController()
              SetUpNavigation(navController = navController)
              // HospitalInfo()
               //ActivityScreen()
               // HomeScreen()
               // LoginScreen()
             // RegisterScreen()



          }
        }
    }
}






