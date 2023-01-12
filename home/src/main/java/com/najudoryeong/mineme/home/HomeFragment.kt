package com.najudoryeong.mineme.home

import android.view.View
import androidx.activity.OnBackPressedCallback
import com.najudoryeong.mineme.common_ui.BaseFragment
import com.najudoryeong.mineme.common_ui.MainViewModelUtil
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

        binding.apply {
            //todo 네비게이션으로 이동할 때 setVisibility해주는게 더 좋을 듯?
            (activity as MainViewModelUtil).run {
                setVisibilityBottomAppbar(View.VISIBLE)
            }
            (activity as MainViewModelUtil).run {
                setVisibilityTopAppBar(View.VISIBLE)
            }
        }
    }

}