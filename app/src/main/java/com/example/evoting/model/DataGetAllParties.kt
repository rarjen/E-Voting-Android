package com.example.evoting.model


import com.google.gson.annotations.SerializedName

data class DataGetAllParties(
    @SerializedName("abbreviation")
    val abbreviation: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("imgUrl")
    val imgUrl: String?,
    @SerializedName("namaPartai")
    val namaPartai: String?
)