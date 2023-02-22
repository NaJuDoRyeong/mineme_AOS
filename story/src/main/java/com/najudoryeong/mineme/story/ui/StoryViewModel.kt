package com.najudoryeong.mineme.story.ui

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.najudoryeong.mineme.common.domain.entity.Story
import com.najudoryeong.mineme.story.domain.entity.StoryListWithDate
import com.najudoryeong.mineme.common.domain.usecase.DataStoreUseCase
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
        "2020", "04", listOf(
            Story(
                "2020-04-01",
                5,
                "마산",
                "https://upload3.inven.co.kr/upload/2022/03/15/bbs/i16343629296.jpg?MW=800"
            ),
            Story(
                "2020-04-02",
                6,
                "마산11",
                "https://upload3.inven.co.kr/upload/2022/03/15/bbs/i16343629296.jpg?MW=800"
            ),
            Story(
                "2020-04-03",
                7,
                "마산21",
                "https://upload3.inven.co.kr/upload/2022/03/15/bbs/i16343629296.jpg?MW=800"
            ),
            Story(
                "2020-04-04",
                8,
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
            try {
                storyUseCase.readStoryList(dataStoreUseCase.bearerJsonWebToken.first()!!).let {
                    _storyList.value = it.toMutableList()
                }
            } catch (e: Exception) {
                // 값을 초기화해서 구독자가 알아차릴 수 있게
            }
            endApiCallBack.invoke()
            _isApiLoading.value = false
        }
    }

    fun postNewStory(){
        viewModelScope.launch {
            _isApiLoading.value = true
            try {
                storyUseCase.readStoryList(dataStoreUseCase.bearerJsonWebToken.first()!!).let {

                }
            } catch (e : Exception){

            }
        }
    }



    fun setToastMessage(newMessage : String){
        _toastMessage.value = ""
        _toastMessage.value = newMessage
    }

    fun setImage(newUriList: List<Uri>){
        _imageUri.value = newUriList.toMutableList()
    }

}