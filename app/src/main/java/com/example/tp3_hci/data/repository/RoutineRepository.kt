package com.example.tp3_hci.data.repository

import com.example.tp3_hci.data.model.Routine
import com.example.tp3_hci.data.model.Sport
import com.example.tp3_hci.data.network.RoutineRemoteDataSource
import com.example.tp3_hci.data.network.SportRemoteDataSource
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class RoutineRepository (
    private val remoteDataSource: RoutineRemoteDataSource
) {
    // Mutex to make writes to cached values thread-safe.
    private val routinesMutex = Mutex()

    // Cache of the latest sports got from the network.
    private var routines: List<Routine> = emptyList()

    suspend fun getRoutines(refresh: Boolean = false, orderBy: String): List<Routine> {
        if (refresh || routines.isEmpty()) {
            val result = remoteDataSource.getRoutines(orderBy)
            // Thread-safe write to latestNews
            routinesMutex.withLock {
                this.routines = result.content.map { it.asModel() }
            }
        }

        return routinesMutex.withLock { this.routines }
    }

    suspend fun getRoutine(routineId: Int): Routine {
        return remoteDataSource.getRoutine(routineId).asModel()
    }
}