package com.example.myhome.data.repository

import android.app.Application
import android.util.Log
import com.example.myhome.data.local.MyHomeDatabase
import com.example.myhome.data.mapper.DoorMapper
import com.example.myhome.data.remote.ApiFactory
import com.example.myhome.domain.entity.Door
import com.example.myhome.domain.repository.DoorRepository

class DoorRepositoryImpl(
    private val application: Application
): DoorRepository{

    private val doorDao = MyHomeDatabase.getInstance(application).doorDao()
    private val apiService = ApiFactory.apiService

    private val mapper = DoorMapper()

    override suspend fun getDoors(): List<Door> {
        return doorDao.getDoors().map {
            mapper.mapDbModelToEntity(it)
        }
    }

    override fun updateDoorName(doorId: Int, newName: String) {
        doorDao.updateDoor(doorId, newName)
    }

    override suspend fun loadDoors() {
        try {
            val doorsDto = apiService.getDoors()

            val doorsDbModel = doorsDto.data.map {
                mapper.mapDtoToDbModel(it)
            }
            doorDao.deleteDoors()
            doorDao.insertDoors(doorsDbModel)
        } catch (e: Exception) {
            Log.e("DoorRepositoryImpl", e.message.toString())
        }
    }
}