package com.example.tp3_hci.data.network.api

import com.example.tp3_hci.data.network.model.NetworkPagedContent
import com.example.tp3_hci.data.network.model.NetworkReview
import com.example.tp3_hci.data.network.model.NetworkReviewParam
import com.example.tp3_hci.data.network.model.NetworkReviewResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiReviewService {
    @GET("reviews/{routineId}")
    suspend fun getReviews(@Path("routineId") routineId: Int): Response<NetworkPagedContent<NetworkReview>>

    @POST("reviews/{routineId}")
    suspend fun addReview(@Path("routineId") routineId: Int, @Body review: NetworkReviewParam): Response<NetworkReviewResponse>
}