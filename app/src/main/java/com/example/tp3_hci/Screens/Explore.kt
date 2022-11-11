package com.example.tp3_hci.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.tp3_hci.R
import com.example.tp3_hci.components.MainAppBar

@Composable
fun ExploreScreen() {
    Scaffold (
        topBar = {
            MainAppBar(title = stringResource(id = R.string.explore_top_text), hasAvatar = false, hasSearch = true)
        },
    ) {
        //
    }
}

@Composable
@Preview
fun ExploreScreenPreview() {
    ExploreScreen()
}