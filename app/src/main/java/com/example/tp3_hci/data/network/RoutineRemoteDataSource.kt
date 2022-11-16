package com.example.tp3_hci.data.network

import com.example.tp3_hci.data.network.api.ApiRoutineService
import com.example.tp3_hci.data.network.model.NetworkPagedContent
import com.example.tp3_hci.data.network.model.NetworkRoutine

class RoutineRemoteDataSource (
    private val apiRoutineService: ApiRoutineService
) : RemoteDataSource() {

    suspend fun getRoutines(orderBy: String) : NetworkPagedContent<NetworkRoutine> {
        return handleApiResponse {
            apiRoutineService.getRoutines(orderBy)
        }
    }

    suspend fun getRoutine(routineId: Int) : NetworkRoutine {
        return handleApiResponse {
            apiRoutineService.getRoutine(routineId)
        }
    }
}