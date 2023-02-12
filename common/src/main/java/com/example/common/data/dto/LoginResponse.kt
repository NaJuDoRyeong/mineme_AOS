package com.example.common.data.dto

import com.example.common.data.entity.LoginData

data class LoginResponse(
    val success: Boolean,
    val data: LoginData
)