package com.najudoryeong.mineme.story.ui

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.najudoryeong.mineme.common.domain.entity.Story
import com.najudoryeong.mineme.story.domain.entity.StoryListWithDate
import com.najudoryeong.mineme.common.domain.usecase.DataStoreUseCase
import com.najudoryeong.mineme.common_ui.ToastType
import com.najudoryeong.mineme.story.R
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
                2,
                "마산1",
                "https://upload3.inven.co.kr/upload/2022/03/15/bbs/i16343629296.jpg?MW=800"
            ),
            Story(
                "2020-03-03",
                3,
                "마산2",
                "https://upload3.inven.co.kr/upload/2022/03/15/bbs/i16343629296.jpg?MW=800"
            ),
            Story(
                "2020-03-04",
                4,
                "마산3",
                "https://upload3.inven.co.kr/upload/2022/03/15/bbs/i16343629296.jpg?MW=800"
            ),
        )
    ),

    StoryListWithDate(
        "2023", "03", listOf(
            Story(
                "2023-03-14",
                5,
                "마산",
                "https://mineme-bucket.s3.ap-northeast-2.amazonaws.com/buddyvet/prod/2/0811f026-4fda-4d28-a416-5b9f1f74b28d.jpg"
            )

        )
    )
)

@HiltViewModel
class StoryViewModel @Inject constructor(
    private val storyUseCase: StoryUseCase,
    private val dataStoreUseCase: DataStoreUseCase
) : ViewModel() {

    private val _imageUri = MutableStateFlow<MutableList<Uri>>(mutableListOf())
    val imageUri: StateFlow<List<Uri>> = _imageUri

    private val _storyList = MutableStateFlow<MutableList<StoryListWithDate>>(mutableListOf())
    val storyList: StateFlow<List<StoryListWithDate>> = _storyList

    private val _isApiLoading = MutableStateFlow(true)
    val isApiLoading: StateFlow<Boolean> = _isApiLoading


    private val _toastMessage = MutableStateFlow("")
    val toastMessage: StateFlow<String> = _toastMessage

    fun raedStory(endApiCallBack: () -> Unit = {}) {
        viewModelScope.launch {
            _isApiLoading.value = true
            _storyList.value = dummy
//            try {
//                storyUseCase.readStoryList(dataStoreUseCase.bearerJsonWebToken.first()!!).let {
//                    _storyList.value = it.toMutableList()
//                }
//            } catch (e: Exception) {
//                // 값을 초기화해서 구독자가 알아차릴 수 있게
//            }
            endApiCallBack.invoke()
            _isApiLoading.value = false
        }
    }

    fun createStory() {
        viewModelScope.launch {
            _isApiLoading.value = true
            try {
                storyUseCase.readStoryList(dataStoreUseCase.bearerJsonWebToken.first()!!).let {
                }
            } catch (e: Exception) {

            }
        }
    }


    fun setToastMessage(newMessage: String, toastType: ToastType) {
        _toastMessage.value = ""
        _toastMessage.value = "${toastType.icon}   $newMessage"
    }

    fun setImage(newUriList: List<Uri>) {
        _imageUri.value = newUriList.toMutableList()
    }

}