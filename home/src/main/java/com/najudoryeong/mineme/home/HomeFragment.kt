package com.najudoryeong.mineme.home

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import com.najudoryeong.mineme.common_ui.BaseFragment
import com.najudoryeong.mineme.common_ui.MainActivityUtil
import com.najudoryeong.mineme.home.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding>(Home) {

    override fun initView() {

        //todo recycle
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.finish()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner, callback
        )
    }
}