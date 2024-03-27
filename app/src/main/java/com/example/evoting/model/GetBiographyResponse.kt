package com.example.evoting.model


import com.google.gson.annotations.SerializedName

data class GetBiographyResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("data")
    val `data`: DataBiography?,
    @SerializedName("message")
    val message: String?
)