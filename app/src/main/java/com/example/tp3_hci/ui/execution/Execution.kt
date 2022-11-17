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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_hci.MainActivity
import com.example.tp3_hci.MyApplication
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
import kotlinx.coroutines.*

@Composable
fun ExecutionScreen(
    onNavigateBack: () -> Unit,
    viewModel: ExecutionViewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = getViewModelFactory()),
    routineId: String

) {

    val uiState = viewModel.uiState

    var currentCycleIndex by remember { mutableStateOf(0) }
    var currentExerciseIndex by remember { mutableStateOf(0) }

    fun nextExercise(){
        if (currentExerciseIndex+1 >= uiState.cycleExercises.orEmpty().size) {
            if (currentCycleIndex+1 >= uiState.routineCycles.orEmpty().size) {
                onNavigateBack()
            } else {
                currentCycleIndex++
                currentExerciseIndex=0
            }
        } else {
            currentExerciseIndex++
        }
    }

    var areCyclesLoaded by remember { mutableStateOf(false) }

    //var allExercises by remember { mutableStateOf( HashMap<Int, List<CycleContent>?>() ) }

    //Cargo los ciclos
    LaunchedEffect(key1 = Unit) {
        if (uiState.canGetData) {
            viewModel.getRoutineCycles(routineId.toInt()).invokeOnCompletion {
                areCyclesLoaded = true
            }
        }
    }

    //Cargo ejercicios por ciclo
    LaunchedEffect(key1 = areCyclesLoaded, key2 = currentCycleIndex) {
        if (uiState.canGetData && areCyclesLoaded && uiState.routineCycles != null && uiState.routineCycles.isNotEmpty()) {
            viewModel.getCycleExercises(
                uiState.routineCycles.get(currentCycleIndex)!!.id!!
            )
        }
    }

    if (areCyclesLoaded && uiState.routineCycles==null){
        // TODO: Toast mensaje
        onNavigateBack()
    }

    var currentCycle = uiState.routineCycles?.getOrNull(currentCycleIndex)

    if (uiState.isFetching){
        Text(text = "Loading...")
    } else {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(12.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
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
                //Nombre del ejercicio
                if (areCyclesLoaded && uiState.cycleExercises==null){
                    nextExercise()
                }
                Text(
                    text = uiState.cycleExercises?.get(currentExerciseIndex)?.exercise?.name ?: "Exercise",
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
                    prevFunc = { currentExerciseIndex-- },
                    modifier = Modifier
                        .size(280.dp)
                )
            }
        }
    }
}

