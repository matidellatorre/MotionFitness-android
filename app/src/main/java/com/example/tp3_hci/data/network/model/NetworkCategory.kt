package com.example.tp3_hci.data.network.model

import com.example.tp3_hci.data.model.Category
import com.google.gson.annotations.SerializedName

class NetworkCategory (
    @SerializedName("id"     ) var id     : Int?    = null,
    @SerializedName("name"   ) var name   : String? = null,
    @SerializedName("detail" ) var detail : String? = null
) {
    fun asModel() : Category {
        return Category(
            id = id,
            name = name,
            detail = detail
        )
    }
}