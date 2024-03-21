package com.example.evoting.model


import com.google.gson.annotations.SerializedName

data class GetAllPresidentialResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("data")
    val `data`: List<DataGetAllPresidentialResponse>?,
    @SerializedName("message")
    val message: String?
)