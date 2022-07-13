package com.example.navtest

sealed class Screen(val route : String){
    object WelcomeScreen : Screen("welcome_screen")
    object HomeScreen : Screen("home_screen")
    object DetailScreen : Screen("detail_screen")
}
