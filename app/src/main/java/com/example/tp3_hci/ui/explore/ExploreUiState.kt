package com.example.tp3_hci.ui.explore

import com.example.tp3_hci.data.model.CycleContent
import com.example.tp3_hci.data.model.Review
import com.example.tp3_hci.data.model.Routine
import com.example.tp3_hci.data.model.User

data class ExploreUiState(
    val isAuthenticated: Boolean = false,
    val isFetching: Boolean = false,
    val currentUser: User? = null,
    val routines: List<Routine>? = null,
    val reviews: HashMap<Int, List<Review>> = HashMap<Int, List<Review>>(),
    val message: String? = null
)

val ExploreUiState.canGetCurrentUser: Boolean get() = isAuthenticated
val ExploreUiState.canGetAllRoutines: Boolean get() = isAuthenticated
val ExploreUiState.canGetAllReviews: Boolean get() = isAuthenticated