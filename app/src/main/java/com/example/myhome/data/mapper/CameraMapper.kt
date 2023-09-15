package com.example.myhome.data.mapper

import com.example.myhome.data.local.CameraDbModel
import com.example.myhome.data.remote.model.CameraDto
import com.example.myhome.domain.entity.Camera

class CameraMapper {
    fun mapDtoToDbModel(dto: CameraDto) = CameraDbModel(
        favorites = dto.favorites,
        id = dto.id,
        name = dto.name,
        rec = dto.rec,
        room = dto.room,
        snapshot = dto.snapshot
    )

    fun mapDbModelToEntity(dbModel: CameraDbModel) = Camera(
        favorites = dbModel.favorites,
        id = dbModel.id,
        name = dbModel.name,
        rec = dbModel.rec,
        room = dbModel.room,
        snapshot = dbModel.snapshot
    )
}
