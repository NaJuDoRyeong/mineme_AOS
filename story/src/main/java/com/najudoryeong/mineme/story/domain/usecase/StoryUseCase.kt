package com.najudoryeong.mineme.story.domain.usecase

import com.najudoryeong.mineme.story.domain.entity.StoryListWithDate
import com.najudoryeong.mineme.story.data.StoryService
import javax.inject.Inject

class StoryUseCase @Inject constructor(
    private val storyService : StoryService
){
    suspend fun readStoryList(token: String): List<StoryListWithDate>  = storyService.readStoryList(token).data
    suspend fun postNewStory(token: String) :
}