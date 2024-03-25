package com.example.evoting.model


import com.google.gson.annotations.SerializedName

data class DataGetOneCandidateResponse(
    @SerializedName("id")
    val id: String?,
    @SerializedName("img_url")
    val imgUrl: String?,
    @SerializedName("number")
    val number: Int?,
    @SerializedName("presidental_candidate_id")
    val presidentalCandidateId: String?,
    @SerializedName("presidental_candidate_name")
    val presidentalCandidateName: String?,
    @SerializedName("vice_presidental_candidate_id")
    val vicePresidentalCandidateId: String?,
    @SerializedName("vice_presidental_candidate_name")
    val vicePresidentalCandidateName: String?,
    @SerializedName("mission")
    val mission: List<String>?
)