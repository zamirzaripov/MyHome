package com.example.myhome.domain.usecase

import com.example.myhome.domain.repository.CameraRepository

class LoadCamerasUseCase(private val cameraRepository: CameraRepository) {
    suspend operator fun invoke() = cameraRepository.loadCameras()
}