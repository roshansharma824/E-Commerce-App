package com.example.tummocandroidassignment.ui.presentation.component

import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tummocandroidassignment.ui.navigation.screen.BottomNavItemScreen
import com.example.tummocandroidassignment.ui.presentation.screen.cart.CartViewModel
import com.example.tummocandroidassignment.ui.theme.Green

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    cartViewModel: CartViewModel = hiltViewModel()
) {
    val navigationItems = listOf(
        BottomNavItemScreen.Home,
        BottomNavItemScreen.Favorite,
        BottomNavItemScreen.Cart,
        BottomNavItemScreen.About
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val bottomBarDestination = navigationItems.any { it.route == currentRoute }

    val productCartList by cartViewModel.productCartList.collectAsState()

    if (bottomBarDestination) {
        BottomNavigation(
            backgroundColor = Color.White,
            contentColor = Color.Black,
            modifier = modifier
        ) {
            navigationItems.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        if(productCartList.isNotEmpty() && item.route == "cart_screen"){
                            BadgedBox(badge = { Badge(backgroundColor = Green) { Text("${productCartList.size}") } }) {
                                Icon(imageVector = item.icon, contentDescription = item.title)
                            }
                        }else{
                            Icon(imageVector = item.icon, contentDescription = item.title)
                        }


                    },
                    label = {
                        Text(
                            text = item.title,
                            fontWeight = FontWeight.SemiBold,
                            color = if (currentRoute == item.route) {
                                Green
                            } else Color.Black.copy(0.4f)
                        )
                    },
                    selectedContentColor = Green,
                    unselectedContentColor = Color.Black.copy(0.4f),
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            navController.graph.startDestinationRoute?.let { screen_route ->
                                popUpTo(screen_route) { saveState = true }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }

        }
    }
}

@Preview
@Composable
fun BottomBarPreview() {
    BottomBar(navController = rememberNavController())
}