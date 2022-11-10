package com.example.tp3_hci.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tp3_hci.Screens.ExploreScreen
import com.example.tp3_hci.Screens.HomeScreen
import com.example.tp3_hci.Screens.RoutinesScreen

@Composable
fun MyAppNavHost(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = "home"
    ){
        composable("home") {
            HomeScreen()
        }
        composable("routines") {
            RoutinesScreen()
        }
        composable("explore") {
            ExploreScreen()
        }
    }

}