package com.example.tp3_hci.data.network

import com.example.tp3_hci.data.network.api.ApiCycleExerciseService
import com.example.tp3_hci.data.network.api.ApiRoutineCycleService
import com.example.tp3_hci.data.network.model.NetworkCycleContent
import com.example.tp3_hci.data.network.model.NetworkPagedContent
import com.example.tp3_hci.data.network.model.NetworkRoutineCycle

class CycleExerciseRemoteDataSource (
    private val apiCycleExerciseService: ApiCycleExerciseService
) : RemoteDataSource() {

    suspend fun getCycleExercises(cycleId: Int) : NetworkPagedContent<NetworkCycleContent> {
        return handleApiResponse {
            apiCycleExerciseService.getCycleExercises(cycleId)
        }
    }
}