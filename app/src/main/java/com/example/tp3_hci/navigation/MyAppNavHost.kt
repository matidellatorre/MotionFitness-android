package com.example.tp3_hci.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tp3_hci.Screens.*
import com.example.tp3_hci.ui.login.LogInScreen
import com.example.tp3_hci.ui.main.MainScreen

@Composable
fun MyAppNavHost(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = "login"
    ){
        composable("home") {
            HomeScreen(
                onNavigateToRoutineDetails = { id -> navController.navigate("details/$id")},
                onNavigateToExecution = { id -> navController.navigate("execution/$id")}
            )
        }
        composable("routines") {
            RoutinesScreen(
                onNavigateToRoutineDetails = { id -> navController.navigate("details/$id")},
                onNavigateToExecution = { id -> navController.navigate("execution/$id")}
            )
        }
        composable("explore") {
            ExploreScreen(
                onNavigateToRoutineDetails = { id -> navController.navigate("details/$id")},
                onNavigateToExecution = { id -> navController.navigate("execution/$id")}
            )
        }
        composable("details/1") {
            DetailsScreen(
                onNavigateToCycleDetails = { id -> navController.navigate("details-cycle/$id") }
            )
        }
        composable("execution/1") {
            ExecutionScreen(
                onNavigateBack = { navController.navigateUp() }
            )
        }
        composable("details-cycle/1") {
            CycleDetailsScreen()
        }
        composable("main") {
            MainScreen()
        }
        composable("login") {
            LogInScreen(
                onNavigateToHomeScreen = { navController.navigate("home") }
            )
        }
    }

}