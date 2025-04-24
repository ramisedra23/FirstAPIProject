package com.example.firstapiproject

import java.io.Serializable

data class Player(
    val id: Int,
    val first_name: String,
    val last_name: String,
    val position: String,
    val height_feet: Int?,
    val weight_pounds: Int?,
    val jersey_number: String?,
    val college: String?,
    val country: String?,
    val draft_year: Int?,
    val draft_round: Int?,
    val draft_number: Int?
) : Serializable