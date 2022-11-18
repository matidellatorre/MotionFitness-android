package com.example.tp3_hci.data.model

import com.example.tp3_hci.data.network.model.NetworkReviewParam
import com.example.tp3_hci.data.network.model.NetworkReviewResponse

class ReviewResponse (
    var id     : Int?    = null,
    var date   : Int?    = null,
    var score  : Int?    = null,
    var review : String? = null
){
    fun asNetworkModel() : NetworkReviewResponse {
        return NetworkReviewResponse(
            id = id,
            date = date,
            score = score,
            review = review,
        )
    }
}