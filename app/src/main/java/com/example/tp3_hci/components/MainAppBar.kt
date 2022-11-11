package com.example.tp3_hci.components

import android.content.Context
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.tp3_hci.R

@Composable
fun MainAppBar(navController: NavHostController) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    TopAppBar(
        title = { Text(text = backStackEntry?.destination?.route ?: "Home", fontSize = 28.sp) },
        backgroundColor = MaterialTheme.colors.primary,
        actions = {
//            if (hasSearch) {
//                IconButton(onClick = { /*TODO*/ }) {
//                    Icon(
//                        imageVector = Icons.Default.Search,
//                        contentDescription = null
//                    )
//                }
//            } else if (hasAvatar) {
//                //Avatar
//            }
        },
    )
}