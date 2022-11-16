package com.example.tp3_hci.data.network.model

import com.example.tp3_hci.data.model.RoutineCycle
import com.google.gson.annotations.SerializedName

class NetworkRoutineCycle (
    @SerializedName("id"          ) var id          : Int?    = null,
    @SerializedName("name"        ) var name        : String,
    @SerializedName("detail"      ) var detail      : String? = null,
    @SerializedName("type"        ) var type        : String? = null,
    @SerializedName("order"       ) var order       : Int?    = null,
    @SerializedName("repetitions" ) var repetitions : Int?    = null,
    @SerializedName("metadata"    ) var metadata    : String? = null
) {
    fun asModel() : RoutineCycle {
        return RoutineCycle(
            id = id,
            name = name,
            repetitions = repetitions
        )
    }
}