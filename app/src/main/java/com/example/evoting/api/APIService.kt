package com.example.evoting.api

import com.example.evoting.model.AuthMeResponse
import com.example.evoting.model.CandidateNumberResponse
import com.example.evoting.model.LoginRequest
import com.example.evoting.model.LoginResponse
import com.example.evoting.model.RegisterRequest
import com.example.evoting.model.RegisterResponse
import com.example.evoting.model.TestResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface APIService {

    @GET("test")
    suspend fun testRoute(): TestResponse

    @POST("auth/register")
    suspend fun registerEndpoint(
        @Body request: RegisterRequest
    ): RegisterResponse

    @POST("auth/login")
    suspend fun loginEndpoint(
        @Body request: LoginRequest
    ): LoginResponse

    @GET("auth/whoami")
    suspend fun authMeEndpoint(
        @Header("Authorization") tokenUser: String?
    ): AuthMeResponse

    @GET("pair-number")
    suspend fun getAllPairNumberEndpoint(
        @Header("Authorization") token: String?
    ): CandidateNumberResponse
}