package com.example.myhome.domain.entity

data class Door(
    val favorites: Boolean,
    val id: Int,
    val name: String,
    val room: String? = null,
    val snapshot: String? = null
)