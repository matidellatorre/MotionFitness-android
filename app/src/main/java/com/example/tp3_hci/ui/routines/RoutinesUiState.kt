package com.example.tp3_hci.ui.routines

import com.example.tp3_hci.data.model.Routine
import com.example.tp3_hci.data.model.User

data class RoutinesUiState(
    val isAuthenticated: Boolean = false,
    val isFetching: Boolean = false,
    val currentUser: User? = null,
    val routines: List<Routine>? = null,
    val message: String? = null
)

val RoutinesUiState.canGetCurrentUser: Boolean get() = isAuthenticated
val RoutinesUiState.canGetAllRoutines: Boolean get() = isAuthenticated