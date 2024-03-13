package com.example.evoting.model


import com.google.gson.annotations.SerializedName

data class CreateVoteResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("data")
    val `data`: DataCreateVoteResponse?,
    @SerializedName("message")
    val message: String?
)