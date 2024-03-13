package com.example.evoting.model


import com.google.gson.annotations.SerializedName

data class DataLoginResponse(
    @SerializedName("token")
    val token: String?
)