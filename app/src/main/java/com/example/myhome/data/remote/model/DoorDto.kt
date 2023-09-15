package com.example.myhome.data.remote.model

data class DoorDto(
    val favorites: Boolean,
    val id: Int,
    val name: String,
    val room: String? = null,
    val snapshot: String? = null
)