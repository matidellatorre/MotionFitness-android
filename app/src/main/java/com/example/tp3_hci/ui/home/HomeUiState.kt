package com.example.tp3_hci.ui.home

import com.example.tp3_hci.data.model.User

data class HomeUiState(
    val isAuthenticated: Boolean = false,
    val isFetching: Boolean = false,
    val currentUser: User? = null,
    val message: String? = null
)

val HomeUiState.canGetCurrentUser: Boolean get() = isAuthenticated