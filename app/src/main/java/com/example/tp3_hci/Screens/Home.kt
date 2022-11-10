package com.example.tp3_hci.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
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
import com.example.tp3_hci.components.LittleCard
import com.example.tp3_hci.components.MainAppBar
import com.example.tp3_hci.components.MainBottomBar
import com.example.tp3_hci.components.RoutineCard
import com.example.tp3_hci.ui.theme.TP3HCITheme

@Composable
fun HomeScreen() {
    Scaffold (
        topBar = {
            MainAppBar(title = stringResource(id = R.string.home_top_text), hasAvatar = true, hasSearch = false)
        },
    ) {
        Column() {
            Text(
                text = "Today's training",
                modifier = Modifier
                    .padding(12.dp),
                style = MaterialTheme.typography.h6.copy(
                    fontWeight = FontWeight(500)
                )
            )
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
            ) {
                RoutineCard(name = "Piernas", description = "Beast Mode")
                Text(
                    text = "Suggested trainings",
                    modifier = Modifier
                        .padding(12.dp),
                    style = MaterialTheme.typography.h6.copy(
                        fontWeight = FontWeight(500)
                    )
                )
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    items(10) {
                        LittleCard(name = "Tetee")
                    }
                }
                Text(
                    text = "Favourite trainings",
                    modifier = Modifier
                        .padding(12.dp),
                    style = MaterialTheme.typography.h6.copy(
                        fontWeight = FontWeight(500)
                    )
                )
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    items(10) {
                        LittleCard(name = "Tetee")
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}