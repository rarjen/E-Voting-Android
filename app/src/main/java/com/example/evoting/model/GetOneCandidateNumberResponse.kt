package com.example.evoting.model


import com.google.gson.annotations.SerializedName

data class GetOneCandidateNumberResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("data")
    val `data`: DataGetOneCandidateResponse?,
    @SerializedName("message")
    val message: String?
)