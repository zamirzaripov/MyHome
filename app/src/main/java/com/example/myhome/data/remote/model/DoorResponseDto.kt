package com.example.myhome.data.remote.model

data class DoorResponseDto(
    val `data`: List<DoorDto>,
    val success: Boolean
)