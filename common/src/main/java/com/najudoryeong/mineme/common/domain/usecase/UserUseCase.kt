package com.najudoryeong.mineme.common.domain.usecase

import com.najudoryeong.mineme.common.data.source.UserService
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