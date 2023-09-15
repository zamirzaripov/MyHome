package com.example.myhome.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "camera")
data class CameraDbModel(
    val favorites: Boolean,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val rec: Boolean,
    val room: String? = null,
    val snapshot: String
)
