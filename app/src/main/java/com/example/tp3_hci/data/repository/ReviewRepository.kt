package com.example.tp3_hci.data.repository

import com.example.tp3_hci.data.model.Review
import com.example.tp3_hci.data.model.ReviewParam
import com.example.tp3_hci.data.model.ReviewResponse
import com.example.tp3_hci.data.model.Sport
import com.example.tp3_hci.data.network.ReviewRemoteDataSource
import com.example.tp3_hci.data.network.model.NetworkPagedContent
import com.example.tp3_hci.data.network.model.NetworkReview
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class ReviewRepository(
    private val remoteDataSource: ReviewRemoteDataSource
) {
    // Mutex to make writes to cached values thread-safe.
    private val reviewMutex = Mutex()
    // Cache of the latest sports got from the network.
    private var reviews: List<Review> = emptyList()

    suspend fun getReviews(routineId: Int, refresh: Boolean = true): List<Review> {
        if (refresh || reviews.isEmpty()) {
            val result = remoteDataSource.getReviews(routineId)
            // Thread-safe write to latestNews
            reviewMutex.withLock {
                this.reviews = result.content.map { it.asModel() }
            }
        }

        return reviewMutex.withLock { this.reviews }
    }

    suspend fun addReview(routineId: Int, review: ReviewParam) : ReviewResponse {
        val newReview = remoteDataSource.addReview(routineId, review.asNetworkModel()).asModel()
        reviewMutex.withLock {
            this.reviews = emptyList()
        }
        return newReview
    }
}