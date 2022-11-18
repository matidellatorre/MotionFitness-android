package com.example.tp3_hci.data.network.model

import com.example.tp3_hci.data.model.Review
import com.google.gson.annotations.SerializedName
import java.util.Date

data class NetworkReview (
    @SerializedName("id"     ) var id     : Int,
    @SerializedName("date"   ) var date   : Date?    = null,
    @SerializedName("score"  ) var score  : Int?    = null,
    @SerializedName("review" ) var review : String? = null,
    @SerializedName("user"   ) var user   : NetworkRoutineUser?   = null
) {
    fun asModel() : Review {
        return Review(
            id = id,
            date = date,
            score = score,
            review = review,
        )
    }
}