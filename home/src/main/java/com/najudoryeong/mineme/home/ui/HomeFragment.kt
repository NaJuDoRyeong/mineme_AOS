package com.najudoryeong.mineme.home.ui

import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import com.najudoryeong.mineme.common_ui.BaseFragment
import com.najudoryeong.mineme.home.Home
import com.najudoryeong.mineme.home.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(Home) {

    private val viewModel: HomeViewModel by viewModels()



    override fun initView() {
        /*

        데이터 바인딩 객체의 라이플 사이클 오너를 프래그먼트의 라이프 사이클로 지정하는 것
        이렇게 해야 프래그먼트의 라이프 사이클이 끝날 때 까지 데이터 바인딩을 유지 하며 관찰 가능


        이 작업을 안하면 실시간 데이터 변경 적용 안될 수 있음

         */

        binding.lifecycleOwner =viewLifecycleOwner
        binding.vm = viewModel
        //todo recycle

        viewModel.settingHomeData()

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