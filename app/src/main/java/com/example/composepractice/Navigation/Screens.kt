package com.example.composepractice.Navigation

sealed class Screen(val route:String){

    object RegisterScreen : Screen("Register_Screen")
    object LoginScreen : Screen("Login_Screen")
    object WelcomeScreen : Screen("Welcome_Screen")
    object HomeScreen : Screen("Home_Screen")
    object ActivityScreen : Screen("Activity_Screen")
    object HospitalInfo : Screen("Hospital_Info")
    object MapScreen : Screen("Map_Screen")
    object NewsScreen : Screen("News_Screen")

}

