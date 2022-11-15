package com.example.tp3_hci.ui.appBar

import com.example.tp3_hci.data.model.User

data class MainAppBarUiState(
    val isAuthenticated: Boolean = false,
    val isFetching: Boolean = false,
    val currentUser: User? = null,
    val message: String? = null
)

val MainAppBarUiState.canGetCurrentUser: Boolean get() = isAuthenticated