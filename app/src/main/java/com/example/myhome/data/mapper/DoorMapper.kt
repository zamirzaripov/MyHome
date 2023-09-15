package com.example.myhome.data.mapper

import com.example.myhome.data.local.DoorDbModel
import com.example.myhome.data.remote.model.DoorDto
import com.example.myhome.domain.entity.Door

class DoorMapper {
    fun mapDtoToDbModel(dto: DoorDto) = DoorDbModel(
        favorites = dto.favorites,
        id = dto.id,
        name = dto.name,
        room = dto.room,
        snapshot = dto.snapshot
    )

    fun mapDbModelToEntity(dbModel: DoorDbModel) = Door(
        favorites = dbModel.favorites,
        id = dbModel.id,
        name = dbModel.name,
        room = dbModel.room,
        snapshot = dbModel.snapshot
    )
}