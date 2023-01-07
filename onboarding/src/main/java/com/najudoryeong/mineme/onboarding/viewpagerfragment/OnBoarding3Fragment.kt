package com.najudoryeong.mineme.onboarding.viewpagerfragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.najudoryeong.mineme.onboarding.databinding.FragmentOnBoarding3Binding


class OnBoarding3Fragment : Fragment() {
    //todo ViewBindingPropertyDelegate
    private var _binding: FragmentOnBoarding3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnBoarding3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = OnBoarding3Fragment()
    }

}