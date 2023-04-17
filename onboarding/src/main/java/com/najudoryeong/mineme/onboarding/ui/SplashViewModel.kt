package com.najudoryeong.mineme.onboarding.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.najudoryeong.mineme.onboarding.domain.usecase.AuthUseCase
import com.najudoryeong.mineme.common.domain.usecase.DataStoreUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val authUseCase: AuthUseCase, private val dataStoreUseCase: DataStoreUseCase
) : ViewModel() {


    /** viewmodel이 아닌 곳에서 JWT를 불러오는 함수**/
    fun withJsonWebToken(callback: (String?) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            callback.invoke(dataStoreUseCase.bearerJsonWebToken.firstOrNull())
        }
    }

    /** 카카오 소셜 로그인으로 받아온 토큰을 서버에 전송해 JWT를 반환받는 함수 **/
    fun signup(token: String, createCallback: () -> Unit, loginCallback: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = authUseCase.login(token)
                dataStoreUseCase.editJsonWebToken(response.body()?.data?.jwt!!)
                // 200이면 로그인
                if (response.code() == 200) {
                    loginCallback.invoke()
                    // 201이면 회원가입
                } else {
                    createCallback.invoke()
                }
            } catch (e: Exception) {
                Log.d("ApiTest", e.message.toString())
            }
        }
    }

    /** user의 정보를 보내는 함수 **/
    fun inputUserInfo(nickname: String, birthday: String, successCallback: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val token = dataStoreUseCase.bearerJsonWebToken.first()
            if (token != null) {
                authUseCase.inputUserInfo(token, nickname, birthday)
                successCallback.invoke()
            }
        }
    }

    fun inputCouleCode(inputCode: String){
        viewModelScope.launch(Dispatchers.IO) {
            val token = dataStoreUseCase.bearerJsonWebToken.first()
            if (token != null){
                authUseCase.inputCoupleCode(token,inputCode)
            }
        }
    }

}