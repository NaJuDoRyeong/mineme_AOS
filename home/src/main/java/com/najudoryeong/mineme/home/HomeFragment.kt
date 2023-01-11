package com.najudoryeong.mineme.home

import android.view.View
import com.najudoryeong.mineme.common_ui.BaseFragment
import com.najudoryeong.mineme.common_ui.MainViewModelUtil
import com.najudoryeong.mineme.home.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding>(Home) {

    override fun initView() {
        binding.apply {
            (activity as MainViewModelUtil).run {
                setVisibilityBottomAppbar(View.VISIBLE)
            }
            (activity as MainViewModelUtil).run {
                setVisibilityTopAppBar(View.VISIBLE)
            }
        }
    }

}