package com.example.tp3_hci.data.network.model

import com.example.tp3_hci.data.model.Routine
import com.example.tp3_hci.data.model.Sport
import com.example.tp3_hci.data.model.User
import com.google.gson.annotations.SerializedName

class NetworkRoutine (
    @SerializedName("id"         ) var id         : Int?,
    @SerializedName("name"       ) var name       : String,
    @SerializedName("detail"     ) var detail     : String?   = null,
    @SerializedName("date"       ) var date       : Int?      = null,
    @SerializedName("score"      ) var score      : Int?      = null,
    @SerializedName("isPublic"   ) var isPublic   : Boolean,
    @SerializedName("difficulty" ) var difficulty : String,
    @SerializedName("user"       ) var user       : NetworkUserReduced? = NetworkUserReduced(),
    @SerializedName("category"   ) var category   : NetworkCategory? = NetworkCategory(),
    @SerializedName("metadata"   ) var metadata   : String?   = null
) {
    fun asModel() : Routine {
        return Routine(
            id = id,
            name = name,
            detail = detail,
            difficulty = difficulty,
            isPublic = isPublic
        )
    }
}