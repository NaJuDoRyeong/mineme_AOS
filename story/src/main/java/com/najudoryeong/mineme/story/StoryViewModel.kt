package com.najudoryeong.mineme.story

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.data.entity.StoryWithDate
import com.example.common.data.source.StoryService
import com.example.common.domain.usecase.DataStoreUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class StoryViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val storyService: StoryService,
    private val dataStoreUseCase: DataStoreUseCase
) : ViewModel() {

    private val _storyList: MutableStateFlow<List<StoryWithDate>> = MutableStateFlow(mutableListOf())
    val storyList: StateFlow<List<StoryWithDate>> = _storyList

    fun raedStory() {
        //todo isuploading
        viewModelScope.launch {
            storyService.getStoryList(dataStoreUseCase.bearerJsonWebToken.first()!!).let {
                if (it.success) {
                    _storyList.value = it.data
                }
            }
        }
    }


}