package com.example.evoting.model


import com.google.gson.annotations.SerializedName

data class AuthMeResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("data")
    val `data`: DataAuthMeResponse?,
    @SerializedName("message")
    val message: String?
)