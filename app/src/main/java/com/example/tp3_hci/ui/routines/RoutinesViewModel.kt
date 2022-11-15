package com.example.tp3_hci.ui.routines

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp3_hci.data.repository.RoutineRepository
import com.example.tp3_hci.data.repository.UserRepository
import com.example.tp3_hci.util.SessionManager
import kotlinx.coroutines.launch

class RoutinesViewModel (
    private val sessionManager: SessionManager,
    private val userRepository: UserRepository,
    private val routineRepository: RoutineRepository
) : ViewModel() {

    var uiState by mutableStateOf(RoutinesUiState(isAuthenticated = sessionManager.loadAuthToken() != null))
        private set

    fun getRoutines() = viewModelScope.launch {
        uiState = uiState.copy(
            isFetching = true,
            message = null
        )
        runCatching {
            routineRepository.getRoutines(true)
        }.onSuccess { response ->
            uiState = uiState.copy(
                isFetching = false,
                routines = response
            )
        }.onFailure { e ->
            // Handle the error and notify the UI when appropriate.
            uiState = uiState.copy(
                message = e.message,
                isFetching = false)
        }
    }
}