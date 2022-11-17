package com.example.tp3_hci.data.network

import com.example.tp3_hci.data.network.api.ApiFavouriteRoutineService
import com.example.tp3_hci.data.network.model.NetworkPagedContent
import com.example.tp3_hci.data.network.model.NetworkRoutine

class FavouriteRemoteDataSource (
    private val apiFavouriteRoutineService: ApiFavouriteRoutineService
) : RemoteDataSource() {

    suspend fun getFavouriteRoutines() : NetworkPagedContent<NetworkRoutine> {
        return handleApiResponse {
            apiFavouriteRoutineService.getFavouriteRoutines()
        }
    }

    suspend fun addFavouriteRoutine(routineId: Int) : Unit {
        return handleApiResponse {
            apiFavouriteRoutineService.addFavouriteRoutine(routineId)
        }
    }
}