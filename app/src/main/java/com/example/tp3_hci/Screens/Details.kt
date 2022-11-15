package com.example.tp3_hci.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_hci.R
import com.example.tp3_hci.components.CicleEntry

@Composable
fun DetailsScreen(
    onNavigateToCycleDetails: (id:Int) -> Unit,
    routineId: String
) {
    Column() {
        Text(
            text = stringResource(R.string.details_subtitle)+" (id: $routineId)",
            fontSize = 22.sp,
            fontWeight = FontWeight(500),
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp),
        )
        LazyColumn (
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(100) {
                CicleEntry(title = "Ciclo 1", exerciseCount = 5, rounds = 3, onNavigateToCycleDetails)
            }
        }
    }
}
