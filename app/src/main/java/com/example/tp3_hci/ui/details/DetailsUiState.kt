package com.example.tp3_hci.ui.details

import com.example.tp3_hci.data.model.Routine
import com.example.tp3_hci.data.model.RoutineCycle
import com.example.tp3_hci.data.model.User


data class DetailsUiState(
    val isAuthenticated: Boolean = false,
    val isFetching: Boolean = false,
    val currentUser: User? = null,
    val routineCycles: List<RoutineCycle>? = null,
    val message: String? = null
)

val DetailsUiState.canGetCurrentUser: Boolean get() = isAuthenticated
val DetailsUiState.canGetAllRoutineCycles: Boolean get() = isAuthenticated