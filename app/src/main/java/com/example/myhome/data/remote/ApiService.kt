package com.example.myhome.data.remote

import com.example.myhome.data.remote.model.CameraResponseDto
import com.example.myhome.data.remote.model.DoorResponseDto
import retrofit2.http.GET

interface ApiService {
    @GET("rubetek/cameras/")
    suspend fun getCameras(): CameraResponseDto

    @GET("rubetek/doors/")
    suspend fun getDoors(): DoorResponseDto
}