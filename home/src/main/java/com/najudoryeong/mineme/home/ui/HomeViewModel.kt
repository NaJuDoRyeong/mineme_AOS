package com.najudoryeong.mineme.home.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.najudoryeong.mineme.common.domain.usecase.DataStoreUseCase
import com.najudoryeong.mineme.home.domain.entity.HomeData
import com.najudoryeong.mineme.home.domain.usecase.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase,
    private val dataStoreUseCase: DataStoreUseCase
) : ViewModel() {

    private val _isNewStory = MutableStateFlow(true)
    val isNewStory : StateFlow<Boolean> = _isNewStory

    private val _homeData = MutableStateFlow<HomeData?>(null)
    val homeData: StateFlow<HomeData?> = _homeData

    fun settingHomeData() {
        viewModelScope.launch {
            var jwt = dataStoreUseCase.bearerJsonWebToken.first()
            if (jwt == null) jwt = "bearer test"
            homeUseCase.readHomeInfo(jwt).let {
                if (it != null){
                    if (it.newStory.postId == -1){
                        _isNewStory.value = true
                    }
                    _homeData.value = it
                } else {
                    Log.d("TESTAPI","API실패")
                }
            }
        }
    }

}