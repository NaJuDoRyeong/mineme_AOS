package com.najudoryeong.mineme.onboarding.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.najudoryeong.mineme.common.data.dto.CodeRequest
import com.najudoryeong.mineme.common.data.dto.UserInfoRequest
import com.najudoryeong.mineme.common.domain.usecase.AuthUseCase
import com.najudoryeong.mineme.common.domain.usecase.DataStoreUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val dataStoreUseCase: DataStoreUseCase
) : ViewModel() {

    fun withJsonWebToken(callback: (String?) -> Unit) {
        viewModelScope.launch {
            callback.invoke(dataStoreUseCase.bearerJsonWebToken.firstOrNull())
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


    fun signup(token: String, createCallback: () -> Unit, loginCallback: () -> Unit) {
        viewModelScope.launch {
            try {
                val response = authUseCase.login(token)
                dataStoreUseCase.editJsonWebToken(response.body()?.data?.jwt!!)
                if (response.code() == 200) {
                    loginCallback.invoke()
                } else {
                    createCallback.invoke()
                }
            } catch (e: Exception) {
                Log.d("buddyTest", e.message.toString())
            }

        }
    }

    /*


    fun inputUserInfo(token: String, userInfoRequest: UserInfoRequest, callback: () -> Unit) {
        viewModelScope.launch {
            userService.postUserInfo(token, userInfoRequest).let {
                if (it.success) {
                    callback.invoke()
                }
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


    */

}