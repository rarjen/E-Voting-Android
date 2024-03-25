package com.example.evoting.repository

import com.example.evoting.api.APIClient
import com.example.evoting.api.APIService
import com.example.evoting.model.LoginRequest
import com.example.evoting.model.RegisterRequest
import com.example.evoting.model.ResetPasswordRequest
import com.example.evoting.model.VoteRequest

class MyRepository() {
    private val apiService: APIService = APIClient.instance

    //Test
    suspend fun testRouteRepo() = apiService.testRoute()

    //Auth
    suspend fun registerAuth(registerRequest: RegisterRequest) = apiService.registerEndpoint(registerRequest)
    suspend fun loginAuth(loginRequest: LoginRequest) = apiService.loginEndpoint(loginRequest)
    suspend fun authMe(tokenUser: String?) = apiService.authMeEndpoint(tokenUser)
    suspend fun resetPasswordUser(token: String?, resetPasswordRequest: ResetPasswordRequest) = apiService.resetPasswordEndpoint(token, resetPasswordRequest)

    //Pair Number
    suspend fun candidatePairNumber(token: String?, number: String?) = apiService.getAllPairNumberEndpoint(token, number)
    suspend fun getOneCandidatePairNumber(token: String?, id: String) = apiService.getOnePairNumberEndpoint(token, id)

    //Vote
    suspend fun votePost(token: String?, voteRequest: VoteRequest) = apiService.voteEndpoint(token, voteRequest)

    //Voting Result
    suspend fun getAllVoteResult(token: String?) = apiService.getAllVotingResultEndpoint(token)

    //Party
    suspend fun getAllParties(token: String?) = apiService.getAllPartiesEndpoint(token)
    suspend fun getOneParty(token: String?, id: String) = apiService.getOnePartyEndpoint(token, id)

    //Presidential
    suspend fun getAllPresidential(token: String?) = apiService.getAllPresidentialEndpoint(token)

    //Vice Predidential
    suspend fun getAllVicePresidential(token: String?) = apiService.getAllVicePresidentialEndpoint(token)
}