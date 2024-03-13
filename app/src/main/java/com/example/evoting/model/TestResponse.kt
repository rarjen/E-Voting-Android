package com.example.evoting.model


import com.google.gson.annotations.SerializedName

data class TestResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("message")
    val message: String?
)