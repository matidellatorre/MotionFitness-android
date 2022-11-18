package com.example.tp3_hci.data.model

import com.example.tp3_hci.data.network.model.NetworkReviewParam
import com.example.tp3_hci.data.network.model.NetworkReviewResponse
import java.util.*

class ReviewResponse (
    var id     : Int?    = null,
    var date   : Date?    = null,
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