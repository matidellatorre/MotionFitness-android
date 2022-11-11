package com.example.tp3_hci.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tp3_hci.Screens.DetailsScreen
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
        composable("routines/${id}") {
            DetailsScreen(id)
        }
    }

}