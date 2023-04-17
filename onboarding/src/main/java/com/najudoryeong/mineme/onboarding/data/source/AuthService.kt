package com.najudoryeong.mineme.onboarding.data.source

import com.najudoryeong.mineme.common.data.dto.LoginRequest
import com.najudoryeong.mineme.common.data.dto.LoginResponse
import com.najudoryeong.mineme.onboarding.data.entity.Code
import com.najudoryeong.mineme.onboarding.data.entity.UserInfo
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthService {

    @POST("api/v1/auth/kakao")
    suspend fun postToken(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("api/v1/user")
    suspend fun inputUserInfo(
        @Header("Authorization") token: String,
        @Body userInfo: UserInfo
    )

    @POST("api/v1/couple")
    suspend fun inputCoupleCode(
        @Header("Authorization") token: String,
        @Body code: Code
    )
}