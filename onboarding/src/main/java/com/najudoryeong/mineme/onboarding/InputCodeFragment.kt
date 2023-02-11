package com.najudoryeong.mineme.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.common.data.dto.CodeRequest
import com.najudoryeong.mineme.common_ui.MainActivityUtil
import com.najudoryeong.mineme.onboarding.databinding.FragmentInputCodeBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class InputCodeFragment : Fragment() {

    private val viewModel: SplashViewModel by viewModels()

    private var _binding: FragmentInputCodeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInputCodeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.nextButton.setOnClickListener {
            viewModel.getJsonWebToken { JWT ->
                viewModel.inputCode(
                    JWT!!,CodeRequest(binding.code.text.toString())
                ){
                    (requireActivity() as SplashActivity).startHomeActivity()
                }
            }
        }
    }


}