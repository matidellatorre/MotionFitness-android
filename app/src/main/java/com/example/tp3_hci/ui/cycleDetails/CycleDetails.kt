package com.example.tp3_hci.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_hci.R
import com.example.tp3_hci.components.CicleEntry
import com.example.tp3_hci.components.ExerciseEntry
import com.example.tp3_hci.ui.cycleDetails.CycleDetailsViewModel
import com.example.tp3_hci.ui.cycleDetails.canGetAllCycleExercises
import com.example.tp3_hci.ui.details.DetailsViewModel
import com.example.tp3_hci.ui.details.canGetAllRoutineCycles
import com.example.tp3_hci.util.getViewModelFactory
import kotlinx.coroutines.launch


@Composable
fun CycleDetailsScreen(
    cycleId: String,
    viewModel: CycleDetailsViewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = getViewModelFactory())
) {
    val uiState = viewModel.uiState

    LaunchedEffect(key1 = Unit) {
        launch {
            if(uiState.canGetAllCycleExercises)
                viewModel.getCycleExercises(cycleId.toInt())
        }
    }

    Column() {
        //Titulo
        Text(
            text = stringResource(R.string.details_cycle_subtitle)+" (id: $cycleId)",
            fontSize = 22.sp,
            fontWeight = FontWeight(500),
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp),
        )
        //Tabla de ejercicios
        if (uiState.isFetching) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.fetching_message),
                    fontSize = 16.sp
                )
            }
        } else {
            val list = uiState.cycleExercises?.orEmpty()
            LazyColumn(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                items(
                    count = list?.size?:0,
                    key = { index -> index }
                ) { index ->
                    ExerciseEntry(
                        title = list?.get(index)?.exercise?.name ?: "Error",
                        reps = list?.get(index)?.repetitions?:0,
                        time = list?.get(index)?.duration?:0,
                    )
                }
            }
        }
    }
}