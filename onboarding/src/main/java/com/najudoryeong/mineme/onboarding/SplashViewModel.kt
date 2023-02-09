package com.najudoryeong.mineme.onboarding

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.data.dto.CodeRequest
import com.example.common.data.dto.UserInfoRequest
import com.example.common.data.source.AuthService
import com.example.common.data.source.UserService
import com.example.common.domain.usecase.DataStoreUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val authService: AuthService,
    private val userService: UserService,
    private val dataStoreUseCase: DataStoreUseCase
) : ViewModel() {

    fun getJsonWebToken(callback: (String?) -> Unit) {
        viewModelScope.launch {
            callback.invoke(dataStoreUseCase.bearerJsonWebToken.first())
        }
    }

    fun checkPermission(callback: (Int) -> Unit) {
        viewModelScope.launch {
            val permissionNum = dataStoreUseCase.permissionNum.first()
            if (permissionNum != null) {
                callback.invoke(permissionNum)
            } else {
                callback.invoke(0)
            }
        }
    }

    fun setViewPagerNum(num: Int) {
        viewModelScope.launch {
            dataStoreUseCase.editPermissionNum(num)
        }
    }


    fun signup(token: String, callback: () -> Unit) {
        viewModelScope.launch {
            dataStoreUseCase.editJsonWebToken("testtoken123")
            dataStoreUseCase.editUserCode("testcode123")
            callback.invoke()

            /*
            //todo userName
            authService.login(LoginRequest(token,ProviderType.KAKAO.name,"test123")).let {
                if (it.success) {
                    dataStoreUseCase.editJsonWebToken(it.data.jwt)
                    dataStoreUseCase.editUserCode(it.data.code)
                    callback.invoke()
                }
            }
             */

        }
    }

    fun inputUserInfo(token: String, userInfoRequest: UserInfoRequest, callback: () -> Unit) {
        viewModelScope.launch {
            userService.postUserInfo(token, userInfoRequest).let {
                if (it.success) callback.invoke()
            }
        }
    }

    fun inputCode(token: String, codeRequest: CodeRequest, callback: () -> Unit) {
        viewModelScope.launch {
            userService.postTargetCode(token, codeRequest).let {
                if (it.success) callback.invoke()
            }
        }
    }
}