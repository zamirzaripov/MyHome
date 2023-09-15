package com.example.myhome.domain.usecase

import com.example.myhome.domain.entity.Camera
import com.example.myhome.domain.repository.CameraRepository

class GetCamerasUseCase(private val cameraRepository: CameraRepository) {

    suspend operator fun invoke(): List<Camera> = cameraRepository.getCameras()
}