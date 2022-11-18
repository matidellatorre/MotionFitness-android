package com.example.tp3_hci.data.network

import com.example.tp3_hci.data.network.api.ApiReviewService
import com.example.tp3_hci.data.network.api.ApiRoutineService
import com.example.tp3_hci.data.network.model.*

class ReviewRemoteDataSource (
    private val apiReviewService: ApiReviewService
) : RemoteDataSource() {

    suspend fun getReviews(routineId: Int) : NetworkPagedContent<NetworkReview> {
        return handleApiResponse {
            apiReviewService.getReviews(routineId)
        }
    }

    suspend fun addReview(routineId: Int, review: NetworkReviewParam) : NetworkReviewResponse {
        return handleApiResponse {
            apiReviewService.addReview(routineId, review)
        }
    }
}