package com.example.evoting.model


import com.google.gson.annotations.SerializedName

data class DataRegisterResponse(
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("isVoted")
    val isVoted: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("nik")
    val nik: String?,
    @SerializedName("role")
    val role: String?,
    @SerializedName("updatedAt")
    val updatedAt: String?
)