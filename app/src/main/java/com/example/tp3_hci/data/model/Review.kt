package com.example.tp3_hci.data.model

import com.example.tp3_hci.data.network.model.NetworkReview
import com.example.tp3_hci.data.network.model.NetworkRoutineUser
import java.util.*

class Review (
    var id: Int? = null,
    var date: Date? = null,
    var score: Int? = null,
    var review: String? = null,
    var user: User? = null,
){
    fun asNetworkModel() : NetworkReview {
        return NetworkReview(
            id = id,
            date = date,
            score = score,
            review = review,
            user = user?.asNetworkModel()
        )
    }
}