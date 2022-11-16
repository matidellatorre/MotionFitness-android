package com.example.tp3_hci.util

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSavedStateRegistryOwner
import com.example.tp3_hci.MyApplication

@Composable
fun getViewModelFactory(defaultArgs: Bundle? = null): ViewModelFactory {
    val application = (LocalContext.current.applicationContext as MyApplication)
    val sessionManager = application.sessionManager
    val userRepository = application.userRepository
    val sportRepository = application.sportRepository
    val routineRepository = application.routineRepository
    val routineCycleRepository = application.routineCycleRepository
    val cycleExerciseRepository = application.cycleExerciseRepository
    return ViewModelFactory(sessionManager, userRepository, sportRepository, routineRepository, routineCycleRepository, cycleExerciseRepository, LocalSavedStateRegistryOwner.current, defaultArgs)
}