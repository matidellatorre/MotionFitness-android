package com.example.tp3_hci.data.model

import com.example.tp3_hci.data.network.model.NetworkRoutineUser
import java.util.Date

data class User(
    var id: Int?,
    var username: String,
    var firstName: String,
    var lastName: String,
    var email: String,
    var lastActivity: Date? = null
)