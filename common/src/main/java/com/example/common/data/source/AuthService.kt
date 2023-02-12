package com.example.common.data.source

import com.example.common.data.dto.LoginRequest
import com.example.common.data.dto.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("api/v1/oauth/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse
}