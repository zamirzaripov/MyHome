package com.example.myhome.domain.usecase

import com.example.myhome.domain.repository.DoorRepository

class UpdateDoorNameUseCase(private val doorRepository: DoorRepository) {
    operator fun invoke(doorId: Int, newName: String) =
        doorRepository.updateDoorName(doorId, newName)
}