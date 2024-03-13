package com.example.evoting.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.evoting.model.LoginRequest
import com.example.evoting.model.RegisterRequest
import com.example.evoting.repository.MyRepository
import com.example.evoting.util.Resource
import kotlinx.coroutines.Dispatchers

class MyViewModel(private val repository: MyRepository): ViewModel() {

    fun testRoute() = liveData(Dispatchers.IO){
        try {
            emit(Resource.success(data = repository.testRouteRepo()))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error Occurred"))
        }
    }

    fun register(registerRequest: RegisterRequest) = liveData(Dispatchers.IO){
        try {
            emit(Resource.success(data = repository.registerAuth(registerRequest)))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error Occurred"))
        }
    }

    fun login(loginRequest: LoginRequest) = liveData(Dispatchers.IO){
        try {
            emit(Resource.success(data = repository.loginAuth(loginRequest)))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error Occurred"))
        }
    }

    fun authMeAuth(tokenUser: String?) = liveData(Dispatchers.IO){
        try {
            emit(Resource.success(data = repository.authMe(tokenUser)))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error Occurred"))
        }
    }
}