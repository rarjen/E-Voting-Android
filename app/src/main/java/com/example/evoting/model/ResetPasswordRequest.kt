package com.example.evoting.model

data class ResetPasswordRequest (
    val oldPassword: String,
    val newPassword: String,
    val confirmPassword: String
)
