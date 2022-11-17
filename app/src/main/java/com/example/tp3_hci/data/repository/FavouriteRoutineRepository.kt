package com.example.tp3_hci.data.repository

import com.example.tp3_hci.data.model.Routine
import com.example.tp3_hci.data.network.FavouriteRemoteDataSource
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class FavouriteRoutineRepository (
    private val remoteDataSource: FavouriteRemoteDataSource
) {
    // Mutex to make writes to cached values thread-safe.
    private val favouriteMutex = Mutex()

    // Cache of the latest sports got from the network.
    private var favourites: List<Routine> = emptyList()

    suspend fun getFavouriteRoutines(refresh: Boolean = false): List<Routine> {
        if (refresh || favourites.isEmpty()) {
            val result = remoteDataSource.getFavouriteRoutines()
            // Thread-safe write to latestNews
            favouriteMutex.withLock {
                this.favourites = result.content.map { it.asModel() }
            }
        }

        return favouriteMutex.withLock { this.favourites }
    }

    suspend fun addFavouriteRoutine(routineId: Int): Unit {
        return remoteDataSource.addFavouriteRoutine(routineId)
    }
}