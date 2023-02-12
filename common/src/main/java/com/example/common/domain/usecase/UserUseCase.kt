package com.example.common.domain.usecase

import com.example.common.data.dto.HomeResponse
import com.example.common.data.source.UserService
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

//todo Singletone?
@Singleton
class UserUseCase @Inject constructor(
    private val userService: UserService
) {
//    suspend fun getHomeData(token: String): HomeResponse {
//        return userService.getHomeInfo(token)
//    }
}