package com.example.tp3_hci.navigation

import android.content.Intent
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.example.tp3_hci.Screens.*
import com.example.tp3_hci.ui.details.DetailsScreen
import com.example.tp3_hci.ui.execution.ExecutionScreen
import com.example.tp3_hci.ui.explore.ExploreScreen
import com.example.tp3_hci.ui.login.LogInScreen
import com.example.tp3_hci.ui.main.MainScreen
import com.example.tp3_hci.ui.model.OrderBy
import com.example.tp3_hci.ui.rate.RateScreen
import com.example.tp3_hci.ui.routines.RoutinesScreen
import com.example.tp3_hci.ui.settings.SettingsScreen

@Composable
fun MyAppNavHost(navController: NavHostController, orderBy: String){
    NavHost(
        navController = navController,
        startDestination = "home"
    ){
        composable("home") {
            HomeScreen(
                onNavigateToRoutineDetails = { id -> navController.navigate("details/$id")},
                onNavigateToExecution = { id -> navController.navigate("execution/$id")},
                onNavigateToLogin = { navController.navigate("login") },
                onPopStack = { route -> navController.popBackStack(route = route, inclusive = true, saveState = false) }
            )
        }
        composable("routines") {
            RoutinesScreen(
                onNavigateToRoutineDetails = { id -> navController.navigate("details/$id")},
                onNavigateToExecution = { id -> navController.navigate("execution/$id")},
                orderBy = orderBy
            )
        }
        composable("explore") {
            ExploreScreen(
                onNavigateToRoutineDetails = { id -> navController.navigate("details/$id")},
                onNavigateToExecution = { id -> navController.navigate("execution/$id")},
                orderBy = orderBy
            )
        }
        composable(
            route = "details/{routineId}",
                deepLinks = listOf(
                navDeepLink {
                    uriPattern = "https://motionfitnessitba.com/{routineId}"
                    action = Intent.ACTION_VIEW
                }
                ),
            arguments = listOf(
                navArgument("routineId") {
                    type = NavType.StringType
                    defaultValue = "-1"
                }
            )) {
            DetailsScreen(
                onNavigateToCycleDetails = { id -> navController.navigate("details-cycle/$id") },
                routineId = navController.currentBackStackEntry?.arguments?.getString("routineId")?:"-1"
            )
        }
        composable(route = "execution/{routineId}"){
            ExecutionScreen(
                onNavigateBack = { navController.navigateUp() },
                onNavigateToRate = { id -> navController.navigate("rate/$id") },
                routineId=navController.currentBackStackEntry?.arguments?.getString("routineId")?:"-1"
            )
        }
        composable("details-cycle/{cycleId}") {
            CycleDetailsScreen(
                cycleId = navController.currentBackStackEntry?.arguments?.getString("cycleId")?:"-1"
            )
        }
        composable("main") {
            MainScreen()
        }
        composable("login") {
            LogInScreen(
                onNavigateToHomeScreen = { navController.navigate("home") },
            )
        }
        composable("settings") {
            SettingsScreen()
        }
        composable("rate/{routineId}") {
            RateScreen(
                routineId=navController.currentBackStackEntry?.arguments?.getString("routineId")?:"-1"
            )
        }
    }
}