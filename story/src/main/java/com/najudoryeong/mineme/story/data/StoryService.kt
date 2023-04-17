package com.najudoryeong.mineme.story.data

import com.najudoryeong.mineme.common.data.dto.CommonResponse
import com.najudoryeong.mineme.common.data.dto.NullResponse
import com.najudoryeong.mineme.story.data.dto.CreateStoryRequest
import com.najudoryeong.mineme.story.data.dto.ReadStoryListResponse
import com.najudoryeong.mineme.story.domain.entity.StoryListWithDate
import okhttp3.MultipartBody
import retrofit2.http.*

interface StoryService {

    @GET("api/v1/stories")
    suspend fun readStoryList(
        @Header("Authorization") token: String,
    ) : CommonResponse<ReadStoryListResponse>

    @GET("api/v1/stories/{storyId}")
    suspend fun readDetailStory(
        @Header("Authorization") token: String,
        @Path("storyId") storyId: Long,
    ) : CommonResponse<ReadStoryListResponse>

    @POST("api/v1/stories")
    suspend fun createStory(
        @Header("Authorization") token: String,
        @Body createStoryRequest : CreateStoryRequest
    ) : CommonResponse<String?>


    @Multipart
    @POST("api/v1/stories/image")
    suspend fun createStoryImage(
        @Header("Authorization") token: String,
        @Path("storyId") diaryId: Long,
        @Part image: List<MultipartBody.Part>
    ): CommonResponse<String?>
}