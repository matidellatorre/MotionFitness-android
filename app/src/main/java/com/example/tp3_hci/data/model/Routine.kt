package com.example.tp3_hci.data.model

import android.media.MediaRouter.RouteCategory
import com.example.tp3_hci.data.network.model.NetworkRoutine
import java.util.*

class Routine (
    var id: Int? = null,
    var name: String,
    var detail: String? = null,
    var date: Date? = null,
    var score: Int? = null,
    var isPublic: Boolean,
    var difficulty: String,
    var user: RoutineUser? = null,
    var category: Category? = null,
    var metadata: Unit? = null,
) {
    fun asNetworkModel(): NetworkRoutine {
        return NetworkRoutine(
            id = id,
            name = name,
            detail = detail,
            date = date,
            score = score,
            isPublic = isPublic,
            difficulty = difficulty,
            user = user?.asNetworkModel()
        )
    }
}