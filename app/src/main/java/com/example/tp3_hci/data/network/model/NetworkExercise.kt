package com.example.tp3_hci.data.network.model

import com.example.tp3_hci.data.model.Exercise
import com.google.gson.annotations.SerializedName

data class NetworkExercise (
    @SerializedName("id"     ) var id     : Int?    = null,
    @SerializedName("name"   ) var name   : String? = null,
    @SerializedName("detail" ) var detail : String? = null,
    @SerializedName("type"   ) var type   : String? = null,
    @SerializedName("date"   ) var date   : Int?    = null,
    @SerializedName("order"  ) var order  : Int?    = null
) {
    fun asModel() : Exercise {
        return Exercise(
            name = name,
        )
    }
}