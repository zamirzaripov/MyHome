package com.example.myhome.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CameraDao {
    @Query("SELECT * FROM camera")
    suspend fun getAllCameras(): List<CameraDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCameras(camerasDbModel: List<CameraDbModel>)

    @Query("DELETE FROM camera")
    suspend fun deleteCameras()
}