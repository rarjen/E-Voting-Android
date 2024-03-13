package com.example.evoting.model


import com.google.gson.annotations.SerializedName

data class CandidateNumberResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("data")
    val `data`: List<DataCandidateNumberResponse>?,
    @SerializedName("message")
    val message: String?
)