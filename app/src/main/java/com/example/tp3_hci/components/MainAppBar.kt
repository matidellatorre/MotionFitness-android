package com.example.tp3_hci.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.tp3_hci.R

@Composable
fun MainAppBar(title: String, hasAvatar: Boolean, hasSearch: Boolean) {
    TopAppBar(
        title = { Text(text = title, fontSize = 28.sp) },
        backgroundColor = MaterialTheme.colors.primary,
        actions = {
            if (hasSearch) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                }
            } else if (hasAvatar) {
                //Avatar
            }
        }
    )
}