package com.example.evoting.model


import com.google.gson.annotations.SerializedName

data class GetAllPartiesResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("data")
    val `data`: List<DataGetAllParties>?,
    @SerializedName("message")
    val message: String?
)