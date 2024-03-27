package com.example.evoting.model


import com.google.gson.annotations.SerializedName

data class DataBiography(
    @SerializedName("age")
    val age: Int?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("dob")
    val dob: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("imgUrl")
    val imgUrl: String?,
    @SerializedName("namaPartai")
    val namaPartai: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("partyImg")
    val partyImg: String?
)