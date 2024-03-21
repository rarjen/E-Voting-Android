package com.example.evoting.model


import com.google.gson.annotations.SerializedName

data class ResetPasswordResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("data")
    val `data`: List<Int?>?,
    @SerializedName("message")
    val message: String?
)