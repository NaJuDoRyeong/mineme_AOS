package com.najudoryeong.mineme.common.data.dto

data class LoginRequest(
    val accessToken: String,
    val providerType: String,
    val username : String ="dowoo"
    )