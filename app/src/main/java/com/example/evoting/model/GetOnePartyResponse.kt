package com.example.evoting.model


import com.google.gson.annotations.SerializedName

data class GetOnePartyResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("data")
    val `data`: DataGetOneParty?,
    @SerializedName("message")
    val message: String?
)