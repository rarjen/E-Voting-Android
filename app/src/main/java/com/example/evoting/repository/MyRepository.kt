package com.example.evoting.repository

import com.example.evoting.api.APIClient
import com.example.evoting.api.APIService
import com.example.evoting.model.LoginRequest
import com.example.evoting.model.RegisterRequest

class MyRepository() {
    private val apiService: APIService = APIClient.instance

    //Test
    suspend fun testRouteRepo() = apiService.testRoute()

    //Auth
    suspend fun registerAuth(registerRequest: RegisterRequest) = apiService.registerEndpoint(registerRequest)
    suspend fun loginAuth(loginRequest: LoginRequest) = apiService.loginEndpoint(loginRequest)
    suspend fun authMe(tokenUser: String?) = apiService.authMeEndpoint(tokenUser)
}