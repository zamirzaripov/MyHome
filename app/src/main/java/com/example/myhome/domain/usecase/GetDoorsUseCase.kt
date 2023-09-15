package com.example.myhome.domain.usecase

import com.example.myhome.domain.entity.Door
import com.example.myhome.domain.repository.DoorRepository

class GetDoorsUseCase(private val doorRepository: DoorRepository) {

    suspend operator fun invoke(): List<Door> = doorRepository.getDoors()
}