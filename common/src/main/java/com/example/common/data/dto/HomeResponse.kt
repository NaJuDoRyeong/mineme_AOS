package com.example.common.data.dto

import com.example.common.data.entity.HomeData

data class HomeResponse(
    val data: HomeData,
    val success: Boolean
)