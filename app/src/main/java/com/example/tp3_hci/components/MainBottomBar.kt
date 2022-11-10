package com.example.tp3_hci.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Public
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import com.example.tp3_hci.Model.BottomIcon
import com.example.tp3_hci.R

@Composable
fun MainBottomBar() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf(
        BottomIcon(Icons.Default.Home, stringResource(id = R.string.home_top_text)),
        BottomIcon(Icons.Default.FitnessCenter, stringResource(id = R.string.routines_top_text)),
        BottomIcon(Icons.Default.Public, stringResource(id = R.string.explore_top_text))
    )

    BottomNavigation (
        backgroundColor = MaterialTheme.colors.primary
    ) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = { Icon(item.imageVector, contentDescription = null) },
                label = { Text(item.label) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}