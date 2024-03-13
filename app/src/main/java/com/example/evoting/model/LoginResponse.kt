package com.example.evoting.model


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("data")
    val `data`: DataLoginResponse?,
    @SerializedName("message")
    val message: String?
)