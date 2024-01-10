package com.example.composepractice.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composepractice.Activity.LoginScreen
import com.example.composepractice.Screens.ActivityScreen
import com.example.composepractice.Screens.HomeScreen
import com.example.composepractice.Screens.HospitalInfo
import com.example.composepractice.Screens.MapScreen
import com.example.composepractice.Screens.NewsScreen
import com.example.composepractice.Screens.RegisterScreen
import com.example.composepractice.Screens.WelcomeScreen


@Composable
fun SetUpNavigation(
    navController: NavHostController
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.WelcomeScreen.route
    ){
        composable(Screen.WelcomeScreen.route){
            WelcomeScreen(navController = navController)
        }
        composable(Screen.RegisterScreen.route){
            RegisterScreen(navController = navController)
        }
        composable(Screen.LoginScreen.route){
            LoginScreen(navController = navController)
        }
        composable(Screen.HomeScreen.route){
            HomeScreen(navController = navController)
        }
        composable(Screen.NewsScreen.route){
            NewsScreen( navController = navController )
        }
        composable(Screen.MapScreen.route){
            MapScreen( navController = navController )
        }
        composable(Screen.HospitalInfo.route){
            HospitalInfo(navController = navController )
        }
        composable(Screen.ActivityScreen.route){
            ActivityScreen(navController = navController )
        }
    }
}