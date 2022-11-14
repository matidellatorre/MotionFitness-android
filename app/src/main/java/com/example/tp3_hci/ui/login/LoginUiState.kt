package com.example.tp3_hci.ui.login

import com.example.tp3_hci.data.model.User

data class LoginUiState(
    val isAuthenticated: Boolean = false,
    val isFetching: Boolean = false,
    val currentUser: User? = null,
    val message: String? = null
)

val LoginUiState.canGetCurrentUser: Boolean get() = isAuthenticated