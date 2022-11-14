package com.example.tp3_hci.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Public
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.tp3_hci.Model.BottomIcon
import com.example.tp3_hci.R

@Composable
fun MainBottomBar(navController: NavController) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route?: "home"
    val items = listOf(
        BottomIcon(Icons.Default.Home, stringResource(id = R.string.home_top_text),"home"),
        BottomIcon(Icons.Default.FitnessCenter, stringResource(id = R.string.routines_top_text),"routines"),
        BottomIcon(Icons.Default.Public, stringResource(id = R.string.explore_top_text),"explore"),
    )
    val screensToShow = listOf(
        "home",
        "routines",
        "explore",
    )

    if(screensToShow.contains(currentRoute)) {
        BottomNavigation (
            backgroundColor = MaterialTheme.colors.primary
        ) {
            items.forEachIndexed { index, item ->
                BottomNavigationItem(
                    icon = { Icon(item.imageVector, contentDescription = null) },
                    label = { Text(item.label) },
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            navController.graph.startDestinationRoute?.let { screenRoute ->
                                popUpTo(screenRoute) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                )
            }
        }
    }
}