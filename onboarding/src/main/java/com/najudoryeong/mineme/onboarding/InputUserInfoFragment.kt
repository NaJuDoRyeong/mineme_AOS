package com.najudoryeong.mineme.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.najudoryeong.mineme.common_ui.MainActivityUtil
import com.najudoryeong.mineme.onboarding.databinding.FragmentInputUserInfoBinding
import com.najudoryeong.mineme.onboarding.databinding.FragmentLoginBinding


class InputUserInfoFragment : Fragment() {

    private var _binding: FragmentInputUserInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInputUserInfoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.nextButton.setOnClickListener {
            (activity as MainActivityUtil).run {
                navigate(this@InputUserInfoFragment,InputCode)
            }
        }

    }
}