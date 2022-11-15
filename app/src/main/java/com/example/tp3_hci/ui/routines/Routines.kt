package com.example.tp3_hci.ui.routines

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.example.tp3_hci.R
import com.example.tp3_hci.components.RoutineCard
import com.example.tp3_hci.data.model.Routine
import com.example.tp3_hci.ui.home.HomeViewModel
import com.example.tp3_hci.util.getViewModelFactory
import kotlinx.coroutines.launch

@Composable
fun RoutinesScreen(
    onNavigateToRoutineDetails: (id:Int) -> Unit,
    onNavigateToExecution: (id:Int) -> Unit,
    viewModel: RoutinesViewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = getViewModelFactory())
) {
    val uiState = viewModel.uiState
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    LaunchedEffect(key1 = Unit) {
        lifecycle.repeatOnLifecycle(state = Lifecycle.State.CREATED) {
            launch {
                if(uiState.canGetAllRoutines)
                    viewModel.getRoutines()
            }
        }
    }

    Column() {
        Text(
            text = stringResource(R.string.routines_subtitle),
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp)
        )

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
            Text(text="Estoy en el else")
            val list = uiState.routines?.orEmpty()
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(15.dp),
                modifier = Modifier
                    .padding(horizontal = 15.dp)
            ) {
                items(
                    count = 1,
                    key = { index ->
                        list?.get(index)?.id.toString()
                    }
                ) { index ->
                    RoutineCard(
                        name = list?.get(index)?.name ?: "Error",
                        description = list?.get(index)?.detail ?: "",
                        id = list?.get(index)?.id!!,
                        onNavigateToRoutineDetails = onNavigateToRoutineDetails,
                        onNavigateToExecution = onNavigateToExecution
                    )
                }
            }
        }
    }
}