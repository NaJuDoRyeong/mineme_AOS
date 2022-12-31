package com.najudoryeong.mineme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.najudoryeong.mineme.common_ui.MainViewModelUtil


class MainViewModel : ViewModel() {

    private val _toolbarTitle = MutableLiveData<String>()

    val toolbarTitle: LiveData<String>
        get() = _toolbarTitle

    fun updateToolbarTitle(newTitle: String) {
        _toolbarTitle.value = newTitle
    }

}