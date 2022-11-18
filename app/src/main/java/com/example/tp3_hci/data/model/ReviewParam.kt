package com.example.tp3_hci.data.model

import com.example.tp3_hci.data.network.model.NetworkReview
import com.example.tp3_hci.data.network.model.NetworkReviewParam
import java.util.*

class ReviewParam (
    var score: Int,
    var review: String? = null,
){
    fun asNetworkModel() : NetworkReviewParam {
        return NetworkReviewParam(
            score = score,
            review = review,
        )
    }
}