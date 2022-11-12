package com.example.tp3_hci.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_hci.R
import com.example.tp3_hci.components.CicleEntry
import com.example.tp3_hci.components.ExerciseEntry

@Composable
fun CycleDetailsScreen() {
    Column() {
        Text(
            text = stringResource(R.string.details_cycle_subtitle),
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
                ExerciseEntry(title = "Press banca", reps = 10, time = 30)
            }
        }
    }
}