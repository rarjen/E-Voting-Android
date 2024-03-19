package com.example.evoting.model


import com.google.gson.annotations.SerializedName

data class VotingResultResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("data")
    val `data`: List<DataVotingResultResponse>?,
    @SerializedName("message")
    val message: String?
)