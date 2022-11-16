package com.example.tp3_hci.data.network.api

import com.example.tp3_hci.data.network.model.NetworkPagedContent
import com.example.tp3_hci.data.network.model.NetworkRoutineCycle
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRoutineCycleService {

    @GET("routines/{routineId}/cycles")
    suspend fun getRoutineCycles(@Path("routineId") routineId: Int) : Response<NetworkPagedContent<NetworkRoutineCycle>>

}