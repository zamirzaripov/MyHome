package com.example.myhome.domain.repository

import com.example.myhome.domain.entity.Camera

interface CameraRepository {
    suspend fun getCameras(): List<Camera>

    suspend fun loadCameras()
}