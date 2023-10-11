package com.example.tummocandroidassignment.ui.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.example.tummocandroidassignment.ui.navigation.screen.BottomNavItemScreen
import com.example.tummocandroidassignment.ui.navigation.screen.Screen
import com.example.tummocandroidassignment.ui.presentation.screen.about.AboutScreen
import com.example.tummocandroidassignment.ui.presentation.screen.cart.CartScreen
import com.example.tummocandroidassignment.ui.presentation.screen.detail.DetailScreen
import com.example.tummocandroidassignment.ui.presentation.screen.favorite.FavoriteScreen
import com.example.tummocandroidassignment.ui.presentation.screen.home.HomeScreen
import com.example.tummocandroidassignment.ui.presentation.screen.search.SearchScreen
import com.example.tummocandroidassignment.ui.utils.Constants.PRODUCT_ARGUMENT_KEY

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.MAIN,
        startDestination = BottomNavItemScreen.Home.route
    ) {
        composable(route = BottomNavItemScreen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = BottomNavItemScreen.Favorite.route) {
            FavoriteScreen()
        }
        composable(route = BottomNavItemScreen.Cart.route) {
            CartScreen()
        }
        composable(route = BottomNavItemScreen.About.route) {
            AboutScreen()
        }

        searchNavGraph()

        detailsNavGraph()
    }
}

fun NavGraphBuilder.detailsNavGraph() {
    navigation(
        route = Graph.DETAILS,
        startDestination = Screen.Details.route
    ) {
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(PRODUCT_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {
            DetailScreen()
        }
    }
}

fun NavGraphBuilder.searchNavGraph() {
    navigation(
        route = Graph.SEARCH,
        startDestination = Screen.Search.route
    ) {
        composable(route = Screen.Search.route) {
            SearchScreen()
        }
    }
}