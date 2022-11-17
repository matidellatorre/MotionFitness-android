package com.example.tp3_hci.ui.execution

import com.example.tp3_hci.data.model.*


data class ExecutionUiState(
    val isAuthenticated: Boolean = false,
    val isFetching: Boolean = false,
    val routines: List<Routine>? = null,
    val routineCycles: List<RoutineCycle>? = null,
    val cycleExercises: HashMap<Int, List<CycleContent>> = HashMap<Int, List<CycleContent>>(),
    val message: String? = null
)

val ExecutionUiState.canGetData: Boolean get() = isAuthenticated