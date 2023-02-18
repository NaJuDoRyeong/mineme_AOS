package com.najudoryeong.mineme.story.data

import com.najudoryeong.mineme.common.data.dto.CommonResponse
import com.najudoryeong.mineme.story.domain.entity.StoryListWithDate
import retrofit2.http.GET
import retrofit2.http.Header

interface StoryService {

    @GET("api/v1/story/list")
    suspend fun readStoryList(
        @Header("Authorization") token: String,
    ) : CommonResponse<List<StoryListWithDate>>

}