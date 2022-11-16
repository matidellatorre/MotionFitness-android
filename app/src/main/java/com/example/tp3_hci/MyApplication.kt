package com.example.tp3_hci

import android.app.Application
import com.example.tp3_hci.data.network.*
import com.example.tp3_hci.data.network.api.RetrofitClient
import com.example.tp3_hci.data.repository.*
import com.example.tp3_hci.util.SessionManager

class MyApplication : Application() {

    private val userRemoteDataSource: UserRemoteDataSource
        get() = UserRemoteDataSource(sessionManager, RetrofitClient.getApiUserService(this))

    private val sportRemoteDataSource: SportRemoteDataSource
        get() = SportRemoteDataSource(RetrofitClient.getApiSportService(this))

    private val routineRemoteDataSource: RoutineRemoteDataSource
        get() = RoutineRemoteDataSource(RetrofitClient.getApiRoutineService(this))

    private val routineCycleRemoteDataSource: RoutineCycleRemoteDataSource
        get() = RoutineCycleRemoteDataSource(RetrofitClient.getApiRoutineCycleService(this))

    private val cycleExerciseRemoteDataSource: CycleExerciseRemoteDataSource
        get() = CycleExerciseRemoteDataSource(RetrofitClient.getApiCycleExerciseService(this))

    val sessionManager: SessionManager
        get() = SessionManager(this)

    val userRepository: UserRepository
        get() = UserRepository(userRemoteDataSource)

    val sportRepository: SportRepository
        get() = SportRepository(sportRemoteDataSource)

    val routineRepository: RoutineRepository
        get() = RoutineRepository(routineRemoteDataSource)

    val routineCycleRepository: RoutineCycleRepository
        get() = RoutineCycleRepository(routineCycleRemoteDataSource)

    val cycleExerciseRepository: CycleExerciseRepository
        get() = CycleExerciseRepository(cycleExerciseRemoteDataSource)
}