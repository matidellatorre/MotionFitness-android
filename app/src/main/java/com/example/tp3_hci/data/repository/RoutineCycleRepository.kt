package com.example.tp3_hci.data.repository

import com.example.tp3_hci.data.model.Routine
import com.example.tp3_hci.data.model.RoutineCycle
import com.example.tp3_hci.data.network.RoutineCycleRemoteDataSource
import com.example.tp3_hci.data.network.RoutineRemoteDataSource
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class RoutineCycleRepository (
    private val remoteDataSource: RoutineCycleRemoteDataSource
) {
    // Mutex to make writes to cached values thread-safe.
    private val routineCyclesMutex = Mutex()

    // Cache of the latest sports got from the network.
    private var routineCycles: List<RoutineCycle> = emptyList()

    suspend fun getRoutineCycles(routineId: Int, refresh: Boolean = false): List<RoutineCycle> {
        if (refresh || routineCycles.isEmpty()) {
            val result = remoteDataSource.getRoutineCycles(routineId)
            // Thread-safe write to latestNews
            routineCyclesMutex.withLock {
                this.routineCycles = result.content.map { it.asModel() }
            }
        }

        return routineCyclesMutex.withLock { this.routineCycles }
    }
}