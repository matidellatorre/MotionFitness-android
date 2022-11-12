package com.example.tp3_hci.components

import android.content.Context
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.tp3_hci.Model.BottomIcon
import com.example.tp3_hci.Model.TopBarInfo
import com.example.tp3_hci.R

@Composable
fun MainAppBar(navController: NavHostController) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    var currentRoute = backStackEntry?.destination?.route?: "home"
    var topBarInfoMap by remember { mutableStateOf( hashMapOf<String, TopBarInfo>(
        "home" to TopBarInfo("Home", true, false, false),
        "routines" to TopBarInfo("Routines", false, true, false),
        "explore" to TopBarInfo("Explore", false, false, false),
        "details/1" to TopBarInfo("Details", false, true, true),
            )
        )
    }

    if(topBarInfoMap.get(currentRoute) != null){
        TopAppBar(
            title = { Text(text = topBarInfoMap.get(currentRoute)!!.title, fontSize = 28.sp) },
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
            navigationIcon = if (topBarInfoMap.get(currentRoute)!!.hasBackArrow) {
                {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            } else {null},
        )
    }
}