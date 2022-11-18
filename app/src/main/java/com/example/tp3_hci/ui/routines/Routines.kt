package com.example.tp3_hci.ui.routines

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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

@Composable
fun RoutinesScreen(
    onNavigateToRoutineDetails: (id:Int) -> Unit,
    onNavigateToExecution: (id:Int) -> Unit,
    orderBy: String,
    viewModel: RoutinesViewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = getViewModelFactory())
) {
    val uiState = viewModel.uiState

    LaunchedEffect(key1 = Unit) {
        launch {
            if (uiState.canGetAllRoutines) {
                viewModel.getFavouriteRoutines()
            }
        }
    }

    LaunchedEffect(key1 = orderBy) {
        launch {
            if (uiState.canGetAllRoutines) {
                viewModel.getRoutines(orderBy)
            }
        }
    }

    LaunchedEffect(key1 = Unit) {
        launch {
            if (uiState.canGetCurrentUser)
                viewModel.getCurrentUser()
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
                    text = stringResource(id = R.string.loading_message),
                    fontSize = 16.sp
                )
            }
        } else {
            RoutineCardList(
                list = uiState.routines?.filter { routine -> routine.user?.username == uiState.currentUser?.username }.orEmpty(),
                hasReviews = false,
                favouriteList = uiState.favourites.orEmpty(),
                hasFavourites = true,
                addFavourite = { routineId -> viewModel.addFavouriteRoutine(routineId) },
                onNavigateToRoutineDetails = onNavigateToRoutineDetails,
                onNavigateToExecution = onNavigateToExecution)
            Spacer(modifier = Modifier.size(20.dp))
        }
    }
}