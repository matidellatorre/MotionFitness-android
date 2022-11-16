package com.example.tp3_hci.data.network.api

import com.example.tp3_hci.data.network.model.NetworkCycleContent
import com.example.tp3_hci.data.network.model.NetworkPagedContent
import com.example.tp3_hci.data.network.model.NetworkRoutineCycle
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiCycleExerciseService {

    @GET("cycles/{cycleId}/exercises")
    suspend fun getCycleExercises(@Path("cycleId") cycleId: Int) : Response<NetworkPagedContent<NetworkCycleContent>>

}