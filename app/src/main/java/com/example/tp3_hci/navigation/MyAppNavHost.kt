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
            ExploreScreen(
                onNavigateToRoutineDetails = { id -> navController.navigate("details/$id")}
            )
        }
        composable("details/1") {
            DetailsScreen(
                onNavigateToCycleDetails = { id -> navController.navigate("details-cycle/$id") }
            )
        }
        composable("execution") {
            ExecutionScreen()
        }
        composable("details-cycle/1") {
            CycleDetailsScreen()
        }
    }

}