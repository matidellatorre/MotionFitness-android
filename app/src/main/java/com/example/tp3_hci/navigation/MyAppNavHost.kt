package com.example.tp3_hci.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tp3_hci.Screens.*

@Composable
fun MyAppNavHost(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = "execution"
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
        composable("execution") {
            ExecutionScreen()
        }
    }

}