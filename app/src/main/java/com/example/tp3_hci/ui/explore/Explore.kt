package com.example.tp3_hci.ui.explore

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_hci.R
import com.example.tp3_hci.components.RoutineCardList
import com.example.tp3_hci.util.getViewModelFactory
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

@Composable
fun ExploreScreen(
    onNavigateToRoutineDetails: (id:Int) -> Unit,
    onNavigateToExecution: (id:Int) -> Unit,
    orderBy: String,
    viewModel: ExploreViewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = getViewModelFactory())

) {

    var boca by remember { mutableStateOf(false) }
    var rivar by remember { mutableStateOf(false) }
    var finishedThreads by remember { mutableStateOf(0) }
    val mutex = Mutex()

    val uiState = viewModel.uiState

    //-----
    LaunchedEffect(key1 = Unit) {
        launch {
            if (uiState.canGetAllRoutines) {
                viewModel.getCurrentUser()
                viewModel.getRoutines(orderBy).invokeOnCompletion {
                    boca = true
                }
            }
        }
    }

    LaunchedEffect(key1 = boca) {
        launch {
            if (boca) {
                uiState.routines?.forEach { it ->
                    viewModel.getReviews(it?.id!!)
                    mutex.withLock {
                        finishedThreads++
                    }
                }
            }
        }
    }

    LaunchedEffect(key1 = finishedThreads) {
        launch {
            if (finishedThreads == uiState.routines?.size) {
                rivar = true
            }
        }
    }

    //-----

    if (rivar) {
        Column() {
            Text(
                text = stringResource(R.string.explore_subtitle),
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
                        text = stringResource(id = R.string.loading_message),
                        fontSize = 16.sp
                    )
                }
            } else {
                RoutineCardList(
                    list = uiState.routines?.filter { routine -> routine.user?.username != uiState.currentUser?.username }
                        .orEmpty(),
                    hasReviews = true,
                    reviews = uiState.reviews,
                    hasFavourites = false,
                    onNavigateToRoutineDetails = onNavigateToRoutineDetails,
                    onNavigateToExecution = onNavigateToExecution,
                )
            }
        }
    }
}

