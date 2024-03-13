package com.example.evoting.model

data class LoginRequest(
    val nikOrEmailOrPhone: String,
    val password: String
)
