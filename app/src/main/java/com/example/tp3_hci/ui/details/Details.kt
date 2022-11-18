package com.example.tp3_hci.ui.details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HideSource
import androidx.compose.material.icons.filled.NotListedLocation
import androidx.compose.material.icons.filled.Rule
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
import com.example.tp3_hci.components.EmptyState
import com.example.tp3_hci.util.getViewModelFactory
import kotlinx.coroutines.launch

@Composable
fun DetailsScreen(
    onNavigateToCycleDetails: (id:Int) -> Unit,
    routineId: String,
    viewModel: DetailsViewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = getViewModelFactory())
) {
    val uiState = viewModel.uiState

    LaunchedEffect(key1 = Unit) {
        launch {
            if(uiState.canGetAllRoutineCycles)
                viewModel.getRoutineCycles(routineId.toInt())
        }
    }

    Column(modifier = Modifier.fillMaxHeight()) {
        //Titulo
        Text(
            text = stringResource(R.string.details_subtitle),
            fontSize = 22.sp,
            fontWeight = FontWeight(500),
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp),
        )
        //Tabla de ciclos
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
            val list = uiState.routineCycles?.orEmpty()
            if (list==null || list.isEmpty()){
                EmptyState(text = stringResource(id = R.string.empty_routine), Icons.Default.HideSource)
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(
                        count = list?.size?:0,
                        key = { index ->
                            list?.get(index)?.id.toString()
                        }
                    ) { index ->
                        CicleEntry(
                            title = list?.get(index)?.name ?: "Error",
                            rounds = list?.get(index)?.repetitions?:0,
                            onNavigateToCycleDetails = onNavigateToCycleDetails,
                            cycleId = list?.get(index)?.id?:-1
                        )
                    }
                }
            }
        }
    }
}