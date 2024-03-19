package com.example.evoting.model


import com.google.gson.annotations.SerializedName

data class DataVotingResultResponse(
    @SerializedName("candidate_pair_number_id")
    val candidatePairNumberId: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("img_result")
    val imgResult: String?,
    @SerializedName("number")
    val number: Int?,
    @SerializedName("percentage")
    val percentage: Double?,
    @SerializedName("presidental_name")
    val presidentalName: String?,
    @SerializedName("total_vote")
    val totalVote: Int?,
    @SerializedName("vice_presidental_name")
    val vicePresidentalName: String?
)