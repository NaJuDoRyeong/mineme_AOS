package com.najudoryeong.mineme.common.data.dto

import com.najudoryeong.mineme.common.data.entity.LoginData

data class LoginResponse(
    val success: Boolean,
    val data: LoginData
)