package com.example.evoting.model


import com.google.gson.annotations.SerializedName

data class DataGetOneParty(
    @SerializedName("abbreviation")
    val abbreviation: String?,
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("img_url")
    val imgUrl: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("updatedAt")
    val updatedAt: String?
)