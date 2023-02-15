package com.najudoryeong.mineme.onboarding.ui

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.snackbar.Snackbar
import com.najudoryeong.mineme.common_ui.DialogForPermission
import com.najudoryeong.mineme.onboarding.R
import com.najudoryeong.mineme.onboarding.databinding.FragmentOnBoardingViewPagerBinding
import com.najudoryeong.mineme.onboarding.ui.viewpagerfragment.OnBoarding1Fragment
import com.najudoryeong.mineme.onboarding.ui.viewpagerfragment.OnBoarding2Fragment
import com.najudoryeong.mineme.onboarding.ui.viewpagerfragment.OnBoarding3Fragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class OnBoardingViewPagerFragment : Fragment() {

    companion object {
        var viewpagerNum = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) 3 else 2
    }

    private val viewModel: SplashViewModel by viewModels()

    //todo ViewBindingPropertyDelegate
    private var _binding: FragmentOnBoardingViewPagerBinding? = null
    private val binding get() = _binding!!


    //todo companion?
    private val messageArray = arrayOf(
        "기록을 위해서 갤러리 및\n" +
                " 위치 접근 동의가 필요해요.   ",
        "사진을 찍기 위해서\n" +
                "카메라 접근 동의가 필요해요",
        "알림을 하기 위해서\n" +
                "푸시 동의가 필요해요."
    )
    private val imageArray = arrayOf(R.drawable.img_gps, R.drawable.img_gps, R.drawable.img_gps)
    private val permissionArray = arrayOf(
        arrayOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,  // 도시 블록 단위
            Manifest.permission.ACCESS_FINE_LOCATION,
        ),
        arrayOf(Manifest.permission.CAMERA),
        arrayOf(Manifest.permission.POST_NOTIFICATIONS)
    )


    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        if (permissions.all { it.value }) {
            if (binding.viewPager2.currentItem == viewpagerNum - 1) {
                findNavController().navigate(R.id.next)
                viewModel.setViewPagerNum(viewpagerNum)
            }
            binding.viewPager2.currentItem++
        } else {
            Snackbar.make(binding.root, "앱을 사용하기 위해 권한 허용을 해주세요!", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun requestPermission(permissionArray: Array<String>) =
        requestPermissionLauncher.launch(permissionArray)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnBoardingViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager2.let {
            it.adapter = OnBoardingViewPagerAdapter(this)
            binding.indicator.setViewPager(it)
        }

        binding.nextButton.setOnClickListener {

            val index = binding.viewPager2.currentItem

            DialogForPermission.Builder(requireContext())
                .setMessage(messageArray[index])
                .setImg(imageArray[index])
                .setOnClickButton {
                    requestPermission(permissionArray[index])
                }.build().show()

        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private inner class OnBoardingViewPagerAdapter(fragment: Fragment) :
        FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int = viewpagerNum

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> OnBoarding1Fragment.newInstance()
                1 -> OnBoarding2Fragment.newInstance()
                else -> OnBoarding3Fragment.newInstance()
            }
        }
    }
}