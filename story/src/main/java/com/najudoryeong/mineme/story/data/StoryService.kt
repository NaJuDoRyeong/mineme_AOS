package com.najudoryeong.mineme.story.data

import com.najudoryeong.mineme.common.data.dto.CommonResponse
import com.najudoryeong.mineme.common.data.dto.NullResponse
import com.najudoryeong.mineme.story.domain.entity.StoryListWithDate

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface StoryService {

    @GET("api/v1/stories")
    suspend fun readStoryList(
        @Header("Authorization") token: String,
    ) : CommonResponse<List<StoryListWithDate>>

//    @POST("api/v1/stories")
//    suspend fun postNewStory(
//        @Header("Authorization") token: String,
//        @Body newStoryRequest: NewStoryRequest
//    ) : NullResponse

}