package com.example.tp3_hci.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_hci.R
import com.example.tp3_hci.components.MainAppBar
import com.example.tp3_hci.components.RoutineCard

@Composable
fun ExploreScreen(
    onNavigateToRoutineDetails: (id:Int) -> Unit
) {
    Column() {
        Text(
            text= stringResource(R.string.explore_subtitle),
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp))
        LazyColumn (
            verticalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier
                .padding(horizontal = 15.dp)
        ) {
            items(10) {
                RoutineCard(name = "Piernas lunes", description = "Placeholder", id=1, onNavigateToRoutineDetails = onNavigateToRoutineDetails)
            }
        }
    }
}

