package com.example.tp3_hci.data.network

import com.example.tp3_hci.data.network.api.ApiRoutineCycleService
import com.example.tp3_hci.data.network.api.ApiRoutineService
import com.example.tp3_hci.data.network.model.NetworkPagedContent
import com.example.tp3_hci.data.network.model.NetworkRoutine
import com.example.tp3_hci.data.network.model.NetworkRoutineCycle

class RoutineCycleRemoteDataSource (
    private val apiRoutineCycleService: ApiRoutineCycleService
) : RemoteDataSource() {

    suspend fun getRoutineCycles(routineId: Int) : NetworkPagedContent<NetworkRoutineCycle> {
        return handleApiResponse {
            apiRoutineCycleService.getRoutineCycles(routineId)
        }
    }
}