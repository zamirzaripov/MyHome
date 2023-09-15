package com.example.myhome.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myhome.data.repository.CameraRepositoryImpl
import com.example.myhome.domain.entity.Camera
import com.example.myhome.domain.usecase.GetCamerasUseCase
import com.example.myhome.domain.usecase.LoadCamerasUseCase
import kotlinx.coroutines.launch

class CameraViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = CameraRepositoryImpl(application)

    private val getCamerasUseCase = GetCamerasUseCase(repository)
    private val loadCamerasUseCase = LoadCamerasUseCase(repository)

    private val _cameras = MutableLiveData<List<Camera>>()
    val cameras: LiveData<List<Camera>>
        get() = _cameras

    suspend fun getCameras(){
        _cameras.value = getCamerasUseCase()
    }

    init {
        viewModelScope.launch {
            loadCamerasUseCase()
        }
    }
}