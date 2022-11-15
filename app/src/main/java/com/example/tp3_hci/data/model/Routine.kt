package com.example.tp3_hci.data.model

import com.example.tp3_hci.data.network.model.NetworkRoutine

class Routine (
    var id: Int? = null,
    var name: String,
    var detail: String? = null,
    var difficulty: String,
    var isPublic: Boolean,
) {
    fun asNetworkModel(): NetworkRoutine {
        return NetworkRoutine(
            id = id,
            name = name,
            detail = detail,
            difficulty = difficulty,
            isPublic = isPublic
        )
    }
}