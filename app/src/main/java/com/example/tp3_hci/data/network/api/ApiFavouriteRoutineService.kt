package com.example.tp3_hci.data.network.api

import com.example.tp3_hci.data.network.model.NetworkPagedContent
import com.example.tp3_hci.data.network.model.NetworkRoutine
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiFavouriteRoutineService {
    @GET("favourites")
    suspend fun getFavouriteRoutines(): Response<NetworkPagedContent<NetworkRoutine>>

    @POST("favourites/{routineId}")
    suspend fun addFavouriteRoutine(@Path("routineId") routineId: Int): Response<Unit>
}