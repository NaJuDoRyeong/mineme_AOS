package com.najudoryeong.mineme.common.data.dto

data class CommonResponse<T>(
    val data: T,
    val success: Boolean
)
