package com.najudoryeong.mineme.onboarding.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.najudoryeong.mineme.onboarding.LoginUtil
import com.najudoryeong.mineme.onboarding.R
import com.najudoryeong.mineme.onboarding.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    @Inject lateinit var mainActivityClass: Class<*>
    private val splashViewModel: SplashViewModel by viewModels({ requireActivity() })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //todo recycle
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.finish()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner, callback
        )

        binding.kakaoLoginBtn.setOnClickListener {
            LoginUtil.loginWithKaKao(requireContext()) { token ->
                splashViewModel.signup(token!!, {
                    LoginUtil.startMainActivity(requireActivity(), mainActivityClass)
                }, { findNavController().navigate(R.id.next) })
            }
        }

    }

}