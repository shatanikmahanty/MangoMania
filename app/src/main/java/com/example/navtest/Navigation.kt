package com.example.navtest

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navtest.screens.DetailScreen
import com.example.navtest.screens.HomeScreen
import com.example.navtest.screens.WelcomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.WelcomeScreen.route) {
        composable(route = Screen.WelcomeScreen.route) {
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.DetailScreen.route + "/{index}",
            arguments = listOf(
                navArgument("index") {
                    type = NavType.IntType
                },
            )
        ) {
            DetailScreen(mangoIndex = it.arguments?.getInt("index"))
        }
    }
}