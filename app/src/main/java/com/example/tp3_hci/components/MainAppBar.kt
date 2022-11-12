package com.example.tp3_hci.components

import android.content.Context
import android.graphics.Color
import android.media.Image
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
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
        "details/1" to TopBarInfo("Details", false, false, true),
        "details-cycle/1" to TopBarInfo("Details", false, false, true),
            )
        )
    }
    var currentTopBarInfo = topBarInfoMap.get(currentRoute)
    var showPopUp by remember { mutableStateOf(false) }
    var context = LocalContext.current

    if(currentTopBarInfo != null){
        TopAppBar(
            title = { Text(text = currentTopBarInfo!!.title, fontSize = 28.sp) },
            backgroundColor = MaterialTheme.colors.primary,
            actions = {
            if (currentTopBarInfo.hasSearch) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                }
            } else if (currentTopBarInfo.hasAvatar) {
                Image(
                    painter = painterResource(R.drawable.bg),
                    contentDescription = "profile picture",
                    contentScale = ContentScale.Crop,            // crop the image if it's not a square
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .clickable { showPopUp = !showPopUp }
                )
                DropdownMenu(
                    expanded = showPopUp,
                    onDismissRequest = { showPopUp = false },
                    modifier = Modifier.background(MaterialTheme.colors.background)
                ) {
                    DropdownMenuItem(onClick = { Toast.makeText(context, "Settings", Toast.LENGTH_SHORT).show() }) {
                        Text(text = "Settings")
                        Icon(imageVector = Icons.Default.Settings, contentDescription = "settings")
                    }
                    DropdownMenuItem(onClick = { Toast.makeText(context, "Logout", Toast.LENGTH_SHORT).show() }) {
                        Text(text = "Logout")
                        Icon(imageVector = Icons.Default.Logout, contentDescription = "logout", tint = Red)
                    }
                }
            }
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