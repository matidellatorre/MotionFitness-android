package com.example.tp3_hci.data.model

data class CycleContent (
    var exercise: Exercise,
    var order: Int? = null,
    var duration: Int? = null,
    var repetitions: Int? = null,
)