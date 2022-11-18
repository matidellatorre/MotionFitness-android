package com.example.tp3_hci.ui.execution

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_hci.components.Timer
import com.example.tp3_hci.data.model.CycleContent
import com.example.tp3_hci.data.model.RoutineCycle
import com.example.tp3_hci.ui.explore.ExploreViewModel
import com.example.tp3_hci.ui.explore.canGetAllRoutines
import com.example.tp3_hci.ui.explore.canGetCurrentUser
import com.example.tp3_hci.ui.model.TopBarInfo
import com.example.tp3_hci.ui.theme.Grey2
import com.example.tp3_hci.ui.theme.GreyGrey
import com.example.tp3_hci.util.getViewModelFactory
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

@Composable
fun ExecutionScreen(
    onNavigateBack: () -> Unit,
    routineId: String,
    viewModel: ExecutionViewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = getViewModelFactory()),

) {
    val uiState = viewModel.uiState

    var currentCycleIndex by remember { mutableStateOf(0) }
    var currentExerciseIndex by remember { mutableStateOf(0) }
    var boca by remember { mutableStateOf(false) }
    var rivar by remember { mutableStateOf(false) }
    var finishedThreads by remember { mutableStateOf(0) }
    val mutex = Mutex()

    //var allExercises by remember { mutableStateOf( HashMap<Int, List<CycleContent>?>() ) }
    fun nextCycle() {
        if (currentCycleIndex + 1 >= uiState.routineCycles.orEmpty().size) {
            onNavigateBack()
        } else {
            currentExerciseIndex = 0
            do {
                currentCycleIndex++
            } while (currentCycleIndex < uiState.routineCycles.orEmpty().size && uiState.cycleExercises.get(uiState.routineCycles!!.getOrNull(currentCycleIndex)!!.id).orEmpty().size == 0)
            if (currentCycleIndex + 1 >= uiState.routineCycles.orEmpty().size)
                onNavigateBack()
        }
    }

    fun nextExercise() {
        if (currentExerciseIndex + 1 >= uiState.cycleExercises.get(uiState.routineCycles!!.getOrNull(currentCycleIndex)!!.id).orEmpty().size) {
            nextCycle()
        } else {
            currentExerciseIndex++
        }
    }


    LaunchedEffect(key1 = Unit) {
        launch {
            if (uiState.canGetData) {
                viewModel.getRoutineCycles(routineId.toInt()).invokeOnCompletion {
                    boca = true
                }
            }
        }
    }

    LaunchedEffect(key1 = boca) {
        launch {
            if (boca) {
                uiState.routineCycles?.forEach { it ->
                    viewModel.getCycleExercises(it?.id!!)
                    mutex.withLock {
                        finishedThreads++
                    }
                    Log.i("AAAAAAAAAAAAAAAAAAAAA", "pase")
                }
            }
        }
    }

    LaunchedEffect(key1 = finishedThreads) {
        launch {
            if (finishedThreads == uiState.routineCycles?.size) {
                rivar = true
            }
        }
    }


    val cycles = uiState.routineCycles
    var currentCycle = uiState.routineCycles?.getOrNull(currentCycleIndex)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        if (rivar) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 6.dp)
                        .padding(top = 3.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Icon(
                        imageVector = Icons.Default.Cancel,
                        contentDescription = null,
                        modifier = Modifier
                            .size(35.dp)
                            .clickable { onNavigateBack() },
                        tint = Grey2
                    )
                }
                //Nombre del ciclo
                Text(
                    text = currentCycle?.name ?: "Cycle",
                    fontSize = 32.sp,
                    fontWeight = FontWeight(500)
                )
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 50.dp, vertical = 10.dp),
                    thickness = 4.dp,
                    color = GreyGrey
                )
                Text(
                    text = uiState.cycleExercises?.getOrDefault(uiState.routineCycles!!.getOrNull(currentCycleIndex)?.id?:-1, null)?.get(currentExerciseIndex)?.exercise?.name ?: "Titulo por defecto",
                    color = MaterialTheme.colors.primary,
                    fontSize = 28.sp,
                    fontWeight = FontWeight(500)
                )
            }
            Box(
                contentAlignment = Alignment.Center,
            ) {
                Timer(
                    totalTime = 10L * 1000L,
                    handleColor = MaterialTheme.colors.primary,
                    inactiveBarColor = GreyGrey,
                    activeBarColor = MaterialTheme.colors.primary,
                    nextFunc = { nextExercise() },
                    prevFunc = { currentCycleIndex-- },
                    modifier = Modifier
                        .size(280.dp)
                )
            }
        } else {
            Text("Loading....")
        }
    }
}

