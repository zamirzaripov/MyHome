package com.example.myhome.domain.entity

data class Camera(
    val favorites: Boolean,
    val id: Int,
    val name: String,
    val rec: Boolean,
    val room: String? = null,
    val snapshot: String
)
