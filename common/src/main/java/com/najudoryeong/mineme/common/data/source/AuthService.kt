package com.najudoryeong.mineme.common.data.source

import com.najudoryeong.mineme.common.data.dto.LoginRequest
import com.najudoryeong.mineme.common.data.dto.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("api/v1/oauth/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse
}