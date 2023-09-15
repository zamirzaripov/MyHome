package com.example.myhome.domain.usecase

import com.example.myhome.domain.repository.DoorRepository

class LoadDoorsUseCase(private val doorRepository: DoorRepository) {
    suspend operator fun invoke() = doorRepository.loadDoors()
}