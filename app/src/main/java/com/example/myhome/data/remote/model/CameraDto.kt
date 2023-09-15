package com.example.myhome.data.remote.model

data class CameraDto(
    val favorites: Boolean,
    val id: Int,
    val name: String,
    val rec: Boolean,
    val room: String? = null,
    val snapshot: String
)