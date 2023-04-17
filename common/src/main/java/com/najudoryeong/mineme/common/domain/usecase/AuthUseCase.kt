package com.najudoryeong.mineme.common.domain.usecase

import com.najudoryeong.mineme.common.data.dto.LoginRequest
import com.najudoryeong.mineme.common.data.dto.LoginResponse
import com.najudoryeong.mineme.common.data.source.AuthService
import retrofit2.Response
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val authService: AuthService
){
    suspend fun login(token: String, providerType: String = "KAKAO"): Response<LoginResponse> {
        return authService.postToken(LoginRequest(token, providerType))
    }

}