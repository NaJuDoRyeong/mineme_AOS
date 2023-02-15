package com.najudoryeong.mineme.onboarding.ui.viewpagerfragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.najudoryeong.mineme.onboarding.databinding.FragmentOnBoarding1Binding


class OnBoarding1Fragment : Fragment() {

    //todo ViewBindingPropertyDelegate
    private var _binding: FragmentOnBoarding1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /**
         *  todo delete
         *  fragment가 destroy 되기 전에 onCreateView가 반복해서 호출될 가능성이 있어
         *  그리고 onDestroyView 를 통해 binding객체가 파괴되지않는 리소스 방지를 위해
         *  binding이 중복해서 생성되는 것을 방지하기 위해 binding의 lifecycleOwner을 viewLifecycleOwner로 선언
         */
        _binding = FragmentOnBoarding1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = OnBoarding1Fragment()
    }
}