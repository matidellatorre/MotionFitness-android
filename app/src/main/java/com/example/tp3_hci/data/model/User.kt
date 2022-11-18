package com.example.tp3_hci.data.model

import com.example.tp3_hci.data.network.model.NetworkRoutineUser
import com.example.tp3_hci.data.network.model.NetworkUser
import java.util.Date

data class User(
    var id: Int?,
    var username: String,
    var firstName: String,
    var lastName: String,
    var email: String,
    var lastActivity: Date? = null
) {
    fun asNetworkModel() : NetworkUser {
        return NetworkUser(
            id = id,
            username = username,
            firstName = firstName,
            lastName = lastName,
            email = email,
            lastActivity = lastActivity
        )
    }
}