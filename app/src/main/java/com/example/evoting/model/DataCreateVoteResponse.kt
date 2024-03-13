package com.example.evoting.model


import com.google.gson.annotations.SerializedName

data class DataCreateVoteResponse(
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("encrypted_candidate_number_id")
    val encryptedCandidateNumberId: String?,
    @SerializedName("encrypted_user_id")
    val encryptedUserId: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("updatedAt")
    val updatedAt: String?
)