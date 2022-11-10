package com.example.tp3_hci.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tp3_hci.Model.BottomIcon
import com.example.tp3_hci.R
import com.example.tp3_hci.components.MainAppBar
import com.example.tp3_hci.components.MainBottomBar
import com.example.tp3_hci.ui.theme.TP3HCITheme

@Composable
fun HomeScreen() {
    Scaffold (
        topBar = {
            MainAppBar(title = stringResource(id = R.string.home_top_text), hasAvatar = true, hasSearch = false)
        },
    ) {
        //
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}