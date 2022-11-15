package com.example.tp3_hci.data.model

import com.example.tp3_hci.data.network.model.NetworkRoutineUser
import java.util.*

data class RoutineUser (
    var id: Int?,
    var username: String?,
    var gender: String?,
    var avatarUrl: String?,
    var date: Date?,
    var lastActivity: Date?
) {
    fun asModel() : NetworkRoutineUser {
        return NetworkRoutineUser(
            id = id,
            username = username,
            gender = gender,
            avatarUrl = avatarUrl,
            date = date,
            lastActivity = lastActivity
        )
    }
}