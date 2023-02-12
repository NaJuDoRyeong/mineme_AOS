package com.najudoryeong.mineme.home

import android.content.Context
import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.data.dto.HomeResponse
import com.example.common.data.entity.HomeData
import com.example.common.data.source.AuthService
import com.example.common.data.source.UserService
import com.example.common.domain.usecase.DataStoreUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val userService: UserService,
    private val dataStoreUseCase: DataStoreUseCase
) : ViewModel() {

    private val _isNewStory = MutableStateFlow(true)
    val isNewStory : StateFlow<Boolean> = _isNewStory

    private val _homeData = MutableStateFlow<HomeData?>(null)
    val homeData: StateFlow<HomeData?> = _homeData


    fun settingHomeData() {
        viewModelScope.launch {
            var a = dataStoreUseCase.bearerJsonWebToken.first()
            if (a == null) a = "bearer test"
            userService.getHomeInfo(a).let {
                if (it.success){
                    Log.d("TESTAPI","API넣음")
                    if (it.data.newStory.postId == -1){
                        _isNewStory.value = true
                    }
                    _homeData.value = it.data

                } else {
                    Log.d("TESTAPI","API실패")
                }
            }
        }
    }

}