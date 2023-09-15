package com.example.myhome.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myhome.data.repository.DoorRepositoryImpl
import com.example.myhome.domain.entity.Door
import com.example.myhome.domain.usecase.GetDoorsUseCase
import com.example.myhome.domain.usecase.LoadDoorsUseCase
import kotlinx.coroutines.launch

class DoorViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = DoorRepositoryImpl(application)

    private val getDoorsUseCase = GetDoorsUseCase(repository)
    private val loadDoorsUseCase = LoadDoorsUseCase(repository)

    private val _doors = MutableLiveData<List<Door>>()
    val doors: LiveData<List<Door>>
        get() = _doors

    suspend fun getDoors(){
        _doors.value = getDoorsUseCase()
    }

    init {
        viewModelScope.launch {
            loadDoorsUseCase()
        }
    }
}