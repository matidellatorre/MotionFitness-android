package com.example.tp3_hci.data.model

import com.example.tp3_hci.data.network.model.NetworkReview
import com.example.tp3_hci.data.network.model.NetworkRoutineUser
import java.util.*

data class Review (
    var id: Int? = null,
    var date: Date? = null,
    var score: Int? = null,
    var review: String? = null,
    var user: RoutineUser? = null,
)