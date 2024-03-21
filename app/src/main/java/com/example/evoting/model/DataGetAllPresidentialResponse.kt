package com.example.evoting.model


import com.google.gson.annotations.SerializedName

data class DataGetAllPresidentialResponse(
    @SerializedName("id")
    val id: String?,
    @SerializedName("imgUrl")
    val imgUrl: String?,
    @SerializedName("name")
    val name: String?
)