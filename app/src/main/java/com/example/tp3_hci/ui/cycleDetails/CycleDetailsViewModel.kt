package com.example.tp3_hci.ui.cycleDetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp3_hci.data.repository.CycleExerciseRepository
import com.example.tp3_hci.data.repository.RoutineCycleRepository
import com.example.tp3_hci.data.repository.UserRepository
import com.example.tp3_hci.ui.details.DetailsUiState
import com.example.tp3_hci.util.SessionManager
import kotlinx.coroutines.launch

class CycleDetailsViewModel (
    private val sessionManager: SessionManager,
    private val userRepository: UserRepository,
    private val cycleExerciseRepository: CycleExerciseRepository
) : ViewModel() {

    var uiState by mutableStateOf(CycleDetailsUiState(isAuthenticated = sessionManager.loadAuthToken() != null))
        private set

    fun getCycleExercises(cycleId: Int) = viewModelScope.launch {
        uiState = uiState.copy(
            isFetching = true,
            message = null
        )
        runCatching {
            cycleExerciseRepository.getCycleExercises(cycleId, true)
        }.onSuccess { response ->
            uiState = uiState.copy(
                isFetching = false,
                cycleExercises = response
            )
        }.onFailure { e ->
            // Handle the error and notify the UI when appropriate.
            uiState = uiState.copy(
                message = e.message,
                isFetching = false)
        }
    }

}