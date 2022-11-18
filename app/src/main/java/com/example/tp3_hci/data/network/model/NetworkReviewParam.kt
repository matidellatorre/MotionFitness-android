package com.example.tp3_hci.data.network.model

import com.google.gson.annotations.SerializedName

class NetworkReviewParam (
    @SerializedName("score") var score : Int,
    @SerializedName("review") var review : String? = null
)