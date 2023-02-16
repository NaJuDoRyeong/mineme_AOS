package com.najudoryeong.mineme.story.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.najudoryeong.mineme.common.domain.entity.Story
import com.najudoryeong.mineme.story.domain.entity.StoryListWithDate
import com.najudoryeong.mineme.common.domain.usecase.DataStoreUseCase
import com.najudoryeong.mineme.story.domain.usecase.StoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

var dummy: MutableList<StoryListWithDate> = mutableListOf(
    StoryListWithDate(
        "2020", "03", listOf(
            Story(
                "2020-03-01",
                1,
                "마산",
                "https://upload3.inven.co.kr/upload/2022/03/15/bbs/i16343629296.jpg?MW=800"
            ),
            Story(
                "2020-03-02",
                1,
                "마산1",
                "https://upload3.inven.co.kr/upload/2022/03/15/bbs/i16343629296.jpg?MW=800"
            ),
            Story(
                "2020-03-03",
                1,
                "마산2",
                "https://upload3.inven.co.kr/upload/2022/03/15/bbs/i16343629296.jpg?MW=800"
            ),
            Story(
                "2020-03-04",
                1,
                "마산3",
                "https://upload3.inven.co.kr/upload/2022/03/15/bbs/i16343629296.jpg?MW=800"
            ),
        )
    ),

    StoryListWithDate(
        "2020", "04", listOf(
            Story(
                "2020-04-01",
                1,
                "마산",
                "https://upload3.inven.co.kr/upload/2022/03/15/bbs/i16343629296.jpg?MW=800"
            ),
            Story(
                "2020-04-02",
                1,
                "마산11",
                "https://upload3.inven.co.kr/upload/2022/03/15/bbs/i16343629296.jpg?MW=800"
            ),
            Story(
                "2020-04-03",
                1,
                "마산21",
                "https://upload3.inven.co.kr/upload/2022/03/15/bbs/i16343629296.jpg?MW=800"
            ),
            Story(
                "2020-04-04",
                1,
                "마산31",
                "https://upload3.inven.co.kr/upload/2022/03/15/bbs/i16343629296.jpg?MW=800"
            ),
        )
    )
)

@HiltViewModel
class StoryViewModel @Inject constructor(
    private val storyUseCase: StoryUseCase,
    private val dataStoreUseCase: DataStoreUseCase
) : ViewModel() {

    private val _storyList = MutableStateFlow<MutableList<StoryListWithDate>>(mutableListOf())
    val storyList: StateFlow<MutableList<StoryListWithDate>> = _storyList

    private val _isApiLoading = MutableStateFlow(true)
    val isApiLoading: StateFlow<Boolean> = _isApiLoading


    private val _toastMessage = MutableStateFlow("")
    val toastMessage: StateFlow<String> = _toastMessage

    fun raedStory(endApiCallBack: () -> Unit = {}) {
        viewModelScope.launch {
            _isApiLoading.value = true

            //_storyList.value = dummy

            try {
                storyUseCase.readStoryList(dataStoreUseCase.bearerJsonWebToken.first()!!).let {
                    if (it != null) {
                        _storyList.value = it.toMutableList()
                    } else {

                    }
                }
            } catch (e: Exception) {
                _toastMessage.value = "스토리리스트 가져오는 거 실패"
            }
            endApiCallBack.invoke()
            _isApiLoading.value = false
        }

    }

}