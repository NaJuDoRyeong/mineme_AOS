package com.najudoryeong.mineme.common.data.source

import com.najudoryeong.mineme.common.data.dto.LoginRequest
import com.najudoryeong.mineme.common.data.dto.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("api/v1/auth/kakao")
    suspend fun postToken(@Body loginRequest: LoginRequest): Response<LoginResponse>
}