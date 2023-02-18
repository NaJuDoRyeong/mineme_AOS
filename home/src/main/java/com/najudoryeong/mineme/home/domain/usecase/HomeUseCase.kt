package com.najudoryeong.mineme.home.domain.usecase


import com.najudoryeong.mineme.home.data.HomeService
import com.najudoryeong.mineme.home.domain.entity.HomeData
import javax.inject.Inject

class HomeUseCase @Inject constructor(
    private val homeService: HomeService
) {
    // response를 entity로 변경하는 mapper 역할까지
    suspend fun readHomeInfo(token: String): HomeData? {
        val homeInfo = homeService.readHomeInfo(token)
        return if (homeInfo.success) homeInfo.data else null
    }
}