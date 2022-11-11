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
            HomeScreen(
                onNavigateToRoutineDetails = { id -> navController.navigate("details/$id")}
            )
        }
        composable("routines") {
            RoutinesScreen(
                onNavigateToRoutineDetails = { id -> navController.navigate("details/$id")}
            )
        }
        composable("explore") {
            ExploreScreen()
        }
        composable("details/1") {
            DetailsScreen()
        }
    }

}