package com.example.tp3_hci.ui.review

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp3_hci.data.model.Review
import com.example.tp3_hci.data.model.ReviewParam
import com.example.tp3_hci.data.model.Sport
import com.example.tp3_hci.data.repository.ReviewRepository
import com.example.tp3_hci.ui.routines.RoutinesUiState
import com.example.tp3_hci.ui.routines.RoutinesViewModel
import com.example.tp3_hci.util.SessionManager
import com.example.tp3_hci.util.getViewModelFactory
import kotlinx.coroutines.launch

class ReviewViewModel (
    private val sessionManager: SessionManager,
    private val reviewRepository: ReviewRepository,
) : ViewModel() {

    var uiState by mutableStateOf(ReviewUiState(isAuthenticated = sessionManager.loadAuthToken() != null))
        private set

    fun addReview(routineId: Int, review: ReviewParam) = viewModelScope.launch {
        uiState = uiState.copy(
            isFetching = true,
            message = null
        )
        runCatching {
            reviewRepository.addReview(routineId, review)
        }.onSuccess { response ->
            uiState = uiState.copy(
                isFetching = false,
            )
        }.onFailure { e ->
            // Handle the error and notify the UI when appropriate.
            uiState = uiState.copy(
                message = e.message,
                isFetching = false)
        }
    }

}