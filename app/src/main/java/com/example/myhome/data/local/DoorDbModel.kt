package com.example.myhome.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "door")
data class DoorDbModel(
    val favorites: Boolean,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val room: String? = null,
    val snapshot: String? = null
)
