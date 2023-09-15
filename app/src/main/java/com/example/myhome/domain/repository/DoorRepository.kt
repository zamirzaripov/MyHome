package com.example.myhome.domain.repository

import com.example.myhome.domain.entity.Door

interface DoorRepository {
    suspend fun getDoors(): List<Door>

    fun updateDoorName(doorId: Int, newName: String)

    suspend fun loadDoors()
}