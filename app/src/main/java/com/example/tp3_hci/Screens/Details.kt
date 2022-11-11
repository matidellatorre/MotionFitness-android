package com.example.tp3_hci.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.tp3_hci.R
import com.example.tp3_hci.components.CicleEntry
import com.example.tp3_hci.components.MainAppBar

@Composable
fun DetailsScreen(id: Int) {
    Scaffold (
        topBar = {
            MainAppBar(title = stringResource(id = R.string.details_top_text), hasAvatar = false, hasSearch = false)
        }
    ) {
        LazyColumn (
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(100) {
                CicleEntry(title = "Ciclo 1", exerciseCount = 5)
                //Divider(thickness = 2.dp)
            }
        }
    }
}
