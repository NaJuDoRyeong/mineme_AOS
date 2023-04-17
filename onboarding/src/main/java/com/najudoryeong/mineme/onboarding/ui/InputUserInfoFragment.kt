package com.najudoryeong.mineme.onboarding.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.najudoryeong.mineme.onboarding.R
import com.najudoryeong.mineme.onboarding.databinding.FragmentInputUserInfoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InputUserInfoFragment : Fragment() {

    private val viewModel: SplashViewModel by viewModels()

    private var _binding: FragmentInputUserInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInputUserInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextButton.setOnClickListener {
            viewModel.inputUserInfo(binding.nameEt.text.toString(),binding.birthDayEt.text.toString()){
                findNavController().navigate(R.id.next)
            }
        }
    }
}