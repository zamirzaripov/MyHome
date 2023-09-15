package com.example.myhome.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DoorDao {
    @Query("SELECT * FROM door")
    suspend fun getDoors(): List<DoorDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDoors(doorsDbModel: List<DoorDbModel>)

    @Query("DELETE FROM door")
    suspend fun deleteDoors()

    @Query("UPDATE door SET name = :newName WHERE id = :doorId")
    fun updateDoor(doorId: Int, newName: String)

}