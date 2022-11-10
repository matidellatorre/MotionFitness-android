package com.example.tp3_hci.Screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.tp3_hci.R
import com.example.tp3_hci.components.MainAppBar

@Composable
fun DetailsScreen(){
    Scaffold (
        topBar = {
            MainAppBar(title = stringResource(id = R.string.details_top_text), hasAvatar = false, hasSearch = false)
        }
    ) {
        //
    }
}
