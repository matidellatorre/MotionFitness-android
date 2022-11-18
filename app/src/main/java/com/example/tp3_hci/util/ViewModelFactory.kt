package com.example.tp3_hci.util

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.tp3_hci.data.repository.*
import com.example.tp3_hci.ui.appBar.MainAppBarViewModel
import com.example.tp3_hci.ui.cycleDetails.CycleDetailsViewModel
import com.example.tp3_hci.ui.details.DetailsViewModel
import com.example.tp3_hci.ui.execution.ExecutionViewModel
import com.example.tp3_hci.ui.explore.ExploreViewModel
import com.example.tp3_hci.ui.home.HomeViewModel
import com.example.tp3_hci.ui.login.LoginViewModel
import com.example.tp3_hci.ui.main.MainViewModel
import com.example.tp3_hci.ui.review.ReviewViewModel
import com.example.tp3_hci.ui.routines.RoutinesViewModel

class ViewModelFactory constructor(
    private val sessionManager: SessionManager,
    private val userRepository: UserRepository,
    private val sportRepository: SportRepository,
    private val routineRepository: RoutineRepository,
    private val routineCycleRepository: RoutineCycleRepository,
    private val cycleExerciseRepository: CycleExerciseRepository,
    private val favouriteRoutineRepository: FavouriteRoutineRepository,
    private val reviewRepository: ReviewRepository,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ) = with(modelClass) {
        when {
            isAssignableFrom(MainViewModel::class.java) ->
                MainViewModel(sessionManager, userRepository, sportRepository)
            isAssignableFrom(LoginViewModel::class.java) ->
                LoginViewModel(sessionManager, userRepository)
            isAssignableFrom(MainAppBarViewModel::class.java) ->
                MainAppBarViewModel(sessionManager, userRepository)
            isAssignableFrom(HomeViewModel::class.java) ->
                HomeViewModel(sessionManager, userRepository, routineRepository, favouriteRoutineRepository)
            isAssignableFrom(RoutinesViewModel::class.java) ->
                RoutinesViewModel(sessionManager, userRepository, routineRepository, favouriteRoutineRepository)
            isAssignableFrom(ExploreViewModel::class.java) ->
                ExploreViewModel(sessionManager, userRepository, routineRepository, reviewRepository)
            isAssignableFrom(DetailsViewModel::class.java) ->
                DetailsViewModel(sessionManager, userRepository, routineCycleRepository)
            isAssignableFrom(CycleDetailsViewModel::class.java) ->
                CycleDetailsViewModel(sessionManager, userRepository, cycleExerciseRepository)
            isAssignableFrom(ExecutionViewModel::class.java) ->
                ExecutionViewModel(sessionManager, userRepository, routineRepository, routineCycleRepository, cycleExerciseRepository)
            isAssignableFrom(ReviewViewModel::class.java) ->
                ReviewViewModel(sessionManager, reviewRepository)
            else ->
                throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    } as T
}