package com.example.tp3_hci.data.network.model

import com.example.tp3_hci.data.model.Review
import com.example.tp3_hci.data.model.Routine
import com.google.gson.annotations.SerializedName
import java.util.*

data class NetworkReview (
    @SerializedName("id"     ) var id     : Int?    = null,
    @SerializedName("date"   ) var date   : Date?    = null,
    @SerializedName("score"  ) var score  : Int?    = null,
    @SerializedName("review" ) var review : String? = null,
    @SerializedName("user"   ) var user   : NetworkUser?   = null
) {
    fun asModel() : Review {
        return Review(
            id = id,
            date = date,
            score = score,
            review = review,
            user = user?.asModel()
        )
    }
}