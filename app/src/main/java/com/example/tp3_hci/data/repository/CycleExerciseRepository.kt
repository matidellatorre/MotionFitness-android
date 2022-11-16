package com.example.tp3_hci.data.repository

import com.example.tp3_hci.data.model.CycleContent
import com.example.tp3_hci.data.model.Exercise
import com.example.tp3_hci.data.model.RoutineCycle
import com.example.tp3_hci.data.network.CycleExerciseRemoteDataSource
import com.example.tp3_hci.data.network.RoutineCycleRemoteDataSource
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class CycleExerciseRepository (
    private val remoteDataSource: CycleExerciseRemoteDataSource
) {
    // Mutex to make writes to cached values thread-safe.
    private val cycleExerciseMutex = Mutex()

    // Cache of the latest sports got from the network.
    private var cycleExercises: List<CycleContent> = emptyList()

    suspend fun getCycleExercises(cycleId: Int, refresh: Boolean = false): List<CycleContent> {
        if (refresh || cycleExercises.isEmpty()) {
            val result = remoteDataSource.getCycleExercises(cycleId)
            // Thread-safe write to latestNews
            cycleExerciseMutex.withLock {
                this.cycleExercises = result.content.map { it.asModel() }
            }
        }

        return cycleExerciseMutex.withLock { this.cycleExercises }
    }
}