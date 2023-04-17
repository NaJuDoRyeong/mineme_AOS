package com.najudoryeong.mineme.onboarding.domain.usecase

import com.najudoryeong.mineme.common.data.dto.LoginRequest
import com.najudoryeong.mineme.common.data.dto.LoginResponse
import com.najudoryeong.mineme.onboarding.data.entity.Code
import com.najudoryeong.mineme.onboarding.data.entity.UserInfo
import com.najudoryeong.mineme.onboarding.data.source.AuthService
import retrofit2.Response
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val authService: AuthService
) {
    suspend fun login(token: String, providerType: String = "KAKAO"): Response<LoginResponse> {
        return authService.postToken(LoginRequest(token, providerType))
    }
    suspend fun inputUserInfo(token: String, nickname: String, birthday: String) {
        val userInfo = UserInfo(nickname, birthday)
        authService.inputUserInfo(token, userInfo)
    }
    suspend fun inputCoupleCode(token : String, inputCode : String){
        val code = Code(inputCode)
        authService.inputCoupleCode(token,code)
    }
}