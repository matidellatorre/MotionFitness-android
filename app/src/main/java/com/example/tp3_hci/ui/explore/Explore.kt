package com.example.tp3_hci.ui.explore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_hci.R
import com.example.tp3_hci.components.RoutineCard
import com.example.tp3_hci.ui.routines.RoutinesViewModel
import com.example.tp3_hci.ui.routines.canGetAllRoutines
import com.example.tp3_hci.util.getViewModelFactory
import kotlinx.coroutines.launch

@Composable
fun ExploreScreen(
    onNavigateToRoutineDetails: (id:Int) -> Unit,
    onNavigateToExecution: (id:Int) -> Unit,
    viewModel: ExploreViewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = getViewModelFactory())

) {

    val uiState = viewModel.uiState

    LaunchedEffect(key1 = Unit) {
        launch {
            if(uiState.canGetAllRoutines)
                viewModel.getRoutines()
            if(uiState.canGetCurrentUser)
                viewModel.getCurrentUser()
        }
    }

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
                    text = stringResource(id = R.string.fetching_message),
                    fontSize = 16.sp
                )
            }
        } else {
            val list = uiState.routines?.filter { routine -> routine.user?.username != uiState.currentUser?.username }.orEmpty()
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(15.dp),
                modifier = Modifier
                    .padding(horizontal = 15.dp)
            ) {
                items(
                    count = list?.size?:0,
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

