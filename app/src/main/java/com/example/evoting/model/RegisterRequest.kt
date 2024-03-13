package com.example.evoting.model

data class RegisterRequest(
    val nik: String,
    val email: String,
    val name: String,
    val password: String,
)
