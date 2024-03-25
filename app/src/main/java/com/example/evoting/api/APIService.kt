package com.example.evoting.api

import com.example.evoting.model.AuthMeResponse
import com.example.evoting.model.CandidateNumberResponse
import com.example.evoting.model.CreateVoteResponse
import com.example.evoting.model.DataGetAllPresidentialResponse
import com.example.evoting.model.GetAllPartiesResponse
import com.example.evoting.model.GetAllPresidentialResponse
import com.example.evoting.model.GetOneCandidateNumberResponse
import com.example.evoting.model.GetOnePartyResponse
import com.example.evoting.model.LoginRequest
import com.example.evoting.model.LoginResponse
import com.example.evoting.model.RegisterRequest
import com.example.evoting.model.RegisterResponse
import com.example.evoting.model.ResetPasswordRequest
import com.example.evoting.model.ResetPasswordResponse
import com.example.evoting.model.TestResponse
import com.example.evoting.model.VoteRequest
import com.example.evoting.model.VotingResultResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

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
        @Header("Authorization") token: String?,
        @Query("number") number: String?
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

    @GET("voting-result")
    suspend fun getAllVotingResultEndpoint(
        @Header("Authorization") token: String?
    ): VotingResultResponse

    @PATCH("auth/reset-password")
    suspend fun resetPasswordEndpoint(
        @Header("Authorization") token: String?,
        @Body request: ResetPasswordRequest
    ): ResetPasswordResponse

    @GET("party")
    suspend fun getAllPartiesEndpoint(
        @Header("Authorization") token: String?
    ): GetAllPartiesResponse

    @GET("presidental")
    suspend fun getAllPresidentialEndpoint(
        @Header("Authorization") token: String?
    ): GetAllPresidentialResponse

    @GET("vice-presidental")
    suspend fun getAllVicePresidentialEndpoint(
        @Header("Authorization") token: String?
    ): GetAllPresidentialResponse

    @GET("party/{id}")
    suspend fun getOnePartyEndpoint(
        @Header("Authorization") token: String?,
        @Path("id") id: String
    ): GetOnePartyResponse
}