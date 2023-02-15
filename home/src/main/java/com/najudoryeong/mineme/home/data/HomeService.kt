package com.najudoryeong.mineme.home.data

import com.najudoryeong.mineme.common.data.dto.CommonResponse
import com.najudoryeong.mineme.home.domain.entity.HomeData
import retrofit2.http.GET
import retrofit2.http.Header

interface HomeService {

    @GET("api/test/main/info")
    suspend fun readHomeInfo(
        @Header("Authorization") token: String,
    ): CommonResponse<HomeData>


}