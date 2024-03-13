package com.example.evoting.model


import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("data")
    val `data`: DataRegisterResponse?,
    @SerializedName("message")
    val message: String?
)