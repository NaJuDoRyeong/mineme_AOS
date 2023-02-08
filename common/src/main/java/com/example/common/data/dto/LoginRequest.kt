package com.example.common.data.dto

data class LoginRequest(
    val accessToken: String,
    val providerType: String,
    val userName: String
)