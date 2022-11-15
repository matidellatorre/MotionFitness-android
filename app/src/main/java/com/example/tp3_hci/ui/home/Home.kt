package com.example.tp3_hci.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.example.tp3_hci.Model.BottomIcon
import com.example.tp3_hci.R
import com.example.tp3_hci.components.LittleCard
import com.example.tp3_hci.components.MainBottomBar
import com.example.tp3_hci.components.RoutineCard
import com.example.tp3_hci.ui.login.LoginViewModel
import com.example.tp3_hci.ui.theme.TP3HCITheme
import com.example.tp3_hci.util.getViewModelFactory
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    onNavigateToRoutineDetails: (id:Int) -> Unit,
    onNavigateToExecution: (id:Int) -> Unit,
    onNavigateToLogin: () -> Unit,
    viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = getViewModelFactory())
) {
    val uiState = viewModel.uiState
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    LaunchedEffect(key1 = Unit) {
        lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
            launch { if(!uiState.isAuthenticated) onNavigateToLogin() }
        }
    }

    Column() {
        Text(
            text = stringResource(R.string.home_subtitle),
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 20.dp),
            style = MaterialTheme.typography.h6.copy(
                fontWeight = FontWeight(500)
            )
        )
        Column (
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ){
                RoutineCard(name = "Piernas", description = "Beast Mode", id=1, onNavigateToRoutineDetails = onNavigateToRoutineDetails, onNavigateToExecution = onNavigateToExecution )
            }
            Text(
                text = stringResource(R.string.home_favourites),
                modifier = Modifier
                    .padding(12.dp),
                style = MaterialTheme.typography.h6.copy(
                    fontWeight = FontWeight(500)
                )
            )
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                item { Spacer(modifier = Modifier.padding(4.dp)) }
                items(10) {
                    LittleCard(name = "Tetee", id=1, onNavigateToRoutineDetails)
                }
                item { Spacer(modifier = Modifier.padding(4.dp)) }
            }
            Text(
                text = stringResource(R.string.home_suggested),
                modifier = Modifier
                    .padding(12.dp),
                style = MaterialTheme.typography.h6.copy(
                    fontWeight = FontWeight(500)
                )
            )
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                item { Spacer(modifier = Modifier.padding(4.dp)) }
                items(10) {
                    LittleCard(name = "Tetee", id=1, onNavigateToRoutineDetails)
                }
                item { Spacer(modifier = Modifier.padding(4.dp)) }
            }
        }
    }
}