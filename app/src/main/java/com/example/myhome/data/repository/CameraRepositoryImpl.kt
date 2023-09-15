package com.example.myhome.data.repository

import android.app.Application
import android.util.Log
import com.example.myhome.data.local.MyHomeDatabase
import com.example.myhome.data.mapper.CameraMapper
import com.example.myhome.data.remote.ApiFactory
import com.example.myhome.domain.entity.Camera
import com.example.myhome.domain.repository.CameraRepository


class CameraRepositoryImpl(
    application: Application
) : CameraRepository {

    private val cameraDao = MyHomeDatabase.getInstance(application).cameraDao()
    private val apiService = ApiFactory.apiService

    private val mapper = CameraMapper()

    override suspend fun getCameras(): List<Camera> {
        return cameraDao.getAllCameras().map {
            mapper.mapDbModelToEntity(it)
        }
    }

    override suspend fun loadCameras() {
        try {
            val camerasDto = apiService.getCameras()

            val camerasDbModel = camerasDto.data.cameras.map {
                mapper.mapDtoToDbModel(it)
            }

            cameraDao.deleteCameras()
            cameraDao.insertCameras(camerasDbModel)
        } catch (e: Exception) {
            Log.e("CameraRepositoryImpl", e.message.toString())
        }
    }
}