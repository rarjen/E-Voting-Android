package com.example.evoting.api

import com.example.evoting.model.AuthMeResponse
import com.example.evoting.model.CandidateNumberResponse
import com.example.evoting.model.CreateVoteResponse
import com.example.evoting.model.GetOneCandidateNumberResponse
import com.example.evoting.model.LoginRequest
import com.example.evoting.model.LoginResponse
import com.example.evoting.model.RegisterRequest
import com.example.evoting.model.RegisterResponse
import com.example.evoting.model.TestResponse
import com.example.evoting.model.VoteRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

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

    @GET("pair-number/{id}")
    suspend fun getOnePairNumberEndpoint(
        @Header("Authorization") token: String?,
        @Path("id") id: String,
    ): GetOneCandidateNumberResponse

    @POST("vote")
    suspend fun voteEndpoint(
        @Header("Authorization") token: String?,
        @Body request: VoteRequest
    ): CreateVoteResponse
}