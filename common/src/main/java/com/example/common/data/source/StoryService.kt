package com.example.common.data.source

import com.example.common.data.dto.StoryListResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface StoryService {
    @GET("api/v1/story/list")
    suspend fun getStoryList(
        @Header("Authorization") token: String,
    ) : StoryListResponse

}