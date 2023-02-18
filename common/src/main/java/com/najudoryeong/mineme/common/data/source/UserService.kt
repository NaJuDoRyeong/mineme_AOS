package com.najudoryeong.mineme.common.data.source

import com.najudoryeong.mineme.common.data.dto.CodeRequest
import com.najudoryeong.mineme.common.data.dto.UserInfoRequest
import com.najudoryeong.mineme.common.data.dto.NullResponse
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface UserService {

    @POST("api/v1/user/info")
    suspend fun postUserInfo(
        @Header("Authorization") token: String,
        @Body userInfoRequest: UserInfoRequest
    ): NullResponse


    @POST("api/v1/user/code")
    suspend fun postTargetCode(
        @Header("Authorization") token: String,
        @Body userCodeRequest: CodeRequest
    ): NullResponse

}