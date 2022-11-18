package com.example.tp3_hci.ui.execution

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_hci.R
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
    val context = LocalContext.current
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

    fun previousCycle() {
        if (currentCycleIndex - 1 < 0) {
            return
        } else {
            var i=1
            while (currentCycleIndex-i >= 0 && uiState.cycleExercises.get(uiState.routineCycles!!.getOrNull(currentCycleIndex-i)!!.id).orEmpty().size == 0){
                i++
            }
            //Encontró un cyclo
            if (currentCycleIndex-i >= 0) {
                currentCycleIndex -= i
                currentExerciseIndex =  uiState.cycleExercises.get(uiState.routineCycles!!.getOrNull(currentCycleIndex)!!.id).orEmpty().size-1
            }
        }
    }

    fun previousExercise() {
        if (currentExerciseIndex - 1 < 0) {
            previousCycle()
        } else {
            currentExerciseIndex--
        }
    }

    val msg = stringResource(id = R.string.no_cycles)

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
                if (uiState.cycleExercises.get(uiState.routineCycles!!.getOrNull(0)?.id)
                        .orEmpty().size == 0
                ) {
                    Text(
                        text = "This routine has no exercises",
                    )
                } else {
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
                        text = uiState.cycleExercises?.getOrDefault(uiState.routineCycles!!.getOrNull(currentCycleIndex)?.id ?: -1, null)?.get(currentExerciseIndex)?.exercise?.name ?: "Titulo por defecto",
                        color = MaterialTheme.colors.primary,
                        fontSize = 28.sp,
                        fontWeight = FontWeight(500)
                    )
                    val reps: String
                    val numReps: Int = uiState.cycleExercises?.getOrDefault(uiState.routineCycles!!.getOrNull(currentCycleIndex)?.id ?: -1, null)?.get(currentExerciseIndex)?.repetitions?:0
                    if(numReps == 0){
                        reps = "--"
                    } else {
                        reps = numReps.toString()
                    }
                    Text(
                        text = "Reps: " + reps,
                        color = Grey2,
                        fontSize = 30.sp,
                        fontWeight = FontWeight(600),
                        modifier = Modifier
                                .padding(top = 6.dp)
                    )
                    Box(
                        contentAlignment = Alignment.Center,
                    ) {
                        Timer(
                            totalTime = uiState.cycleExercises.getOrDefault(uiState.routineCycles!!.getOrNull(currentCycleIndex)?.id ?: -1, null)
                                ?.get(currentExerciseIndex)?.duration?.times(1000L) ?: 0,
                            handleColor = MaterialTheme.colors.primary,
                            inactiveBarColor = GreyGrey,
                            activeBarColor = MaterialTheme.colors.primary,
                            nextFunc = { nextExercise() },
                            prevFunc = { previousExercise() },
                            hasPrev = currentCycleIndex > 0 || currentExerciseIndex > 0,
                            modifier = Modifier
                                .size(280.dp),
                            strokeWidth = 10.dp
                        )
                    }
                }
            }
        } else {
            Text(text = stringResource(R.string.loading_message))
        }
    }
}

