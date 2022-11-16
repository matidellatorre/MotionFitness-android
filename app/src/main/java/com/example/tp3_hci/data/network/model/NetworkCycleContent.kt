package com.example.tp3_hci.data.network.model

import com.example.tp3_hci.data.model.CycleContent
import com.google.gson.annotations.SerializedName

class NetworkCycleContent (
    @SerializedName("exercise"    ) var exercise    : NetworkExercise,
    @SerializedName("order"       ) var order       : Int?      = null,
    @SerializedName("duration"    ) var duration    : Int?      = null,
    @SerializedName("repetitions" ) var repetitions : Int?      = null,
) {
    fun asModel() : CycleContent {
        return CycleContent(
            exercise = exercise.asModel(),
            order = order,
            duration = duration,
            repetitions = repetitions
        )
    }
}