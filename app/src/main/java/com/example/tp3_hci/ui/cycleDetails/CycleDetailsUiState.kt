package com.example.tp3_hci.ui.cycleDetails

import com.example.tp3_hci.data.model.CycleContent
import com.example.tp3_hci.data.model.User

data class CycleDetailsUiState(
    val isAuthenticated: Boolean = false,
    val isFetching: Boolean = false,
    val currentUser: User? = null,
    val cycleExercises: List<CycleContent>? = null,
    val message: String? = null
)

val CycleDetailsUiState.canGetCurrentUser: Boolean get() = isAuthenticated
val CycleDetailsUiState.canGetAllCycleExercises: Boolean get() = isAuthenticated