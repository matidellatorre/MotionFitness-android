package com.example.tp3_hci.ui.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp3_hci.data.repository.RoutineCycleRepository
import com.example.tp3_hci.data.repository.RoutineRepository
import com.example.tp3_hci.data.repository.UserRepository
import com.example.tp3_hci.ui.explore.ExploreUiState
import com.example.tp3_hci.util.SessionManager
import kotlinx.coroutines.launch

class DetailsViewModel (
    private val sessionManager: SessionManager,
    private val userRepository: UserRepository,
    private val routineCycleRepository: RoutineCycleRepository
) : ViewModel() {

    var uiState by mutableStateOf(DetailsUiState(isAuthenticated = sessionManager.loadAuthToken() != null))
        private set

    fun getRoutineCycles(routineId: Int) = viewModelScope.launch {
        uiState = uiState.copy(
            isFetching = true,
            message = null
        )
        runCatching {
            routineCycleRepository.getRoutineCycles(routineId, true)
        }.onSuccess { response ->
            uiState = uiState.copy(
                isFetching = false,
                routineCycles = response
            )
        }.onFailure { e ->
            // Handle the error and notify the UI when appropriate.
            uiState = uiState.copy(
                message = e.message,
                isFetching = false)
        }
    }

}