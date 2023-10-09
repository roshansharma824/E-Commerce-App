package com.example.tummocandroidassignment.ui.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tummocandroidassignment.ui.navigation.screen.Screen
import com.example.tummocandroidassignment.ui.presentation.screen.MainScreen
import com.example.tummocandroidassignment.ui.presentation.screen.onboarding.OnBoardingScreen
import com.example.tummocandroidassignment.ui.presentation.screen.splash.SplashScreen

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screen.OnBoarding.route) {
            OnBoardingScreen(navController = navController)
        }

        composable(route = Graph.MAIN) {
            MainScreen()
        }
    }
}