package com.example.tp3_hci.data.network.api

import com.example.tp3_hci.data.network.model.NetworkPagedContent
import com.example.tp3_hci.data.network.model.NetworkRoutine
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRoutineService {

    @GET("routines")
    suspend fun getRoutines() : Response<NetworkPagedContent<NetworkRoutine>>

    @GET("routines/{routineId}")
    suspend fun getRoutine(@Path("routineId") routineId: Int) : Response<NetworkRoutine>
}