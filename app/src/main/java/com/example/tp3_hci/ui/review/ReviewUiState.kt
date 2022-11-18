package com.example.tp3_hci.ui.review

import com.example.tp3_hci.data.model.Review

data class ReviewUiState(
    val isAuthenticated: Boolean = false,
    val isFetching: Boolean = false,
    val reviews: List<Review>? = null,
    val message: String? = null
)

val ReviewUiState.canGetReviews: Boolean get() = isAuthenticated