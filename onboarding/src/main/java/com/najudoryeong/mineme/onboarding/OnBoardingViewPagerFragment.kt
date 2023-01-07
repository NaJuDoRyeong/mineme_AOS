package com.najudoryeong.mineme.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.najudoryeong.mineme.common_ui.MainViewModelUtil
import com.najudoryeong.mineme.onboarding.databinding.FragmentOnBoardingViewPagerBinding
import com.najudoryeong.mineme.onboarding.viewpagerfragment.OnBoarding1Fragment
import com.najudoryeong.mineme.onboarding.viewpagerfragment.OnBoarding2Fragment
import com.najudoryeong.mineme.onboarding.viewpagerfragment.OnBoarding3Fragment

private const val NUM_PAGES = 3

class OnBoardingViewPagerFragment : Fragment() {

    //todo ViewBindingPropertyDelegate
    private var _binding: FragmentOnBoardingViewPagerBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnBoardingViewPagerBinding.inflate(inflater, container, false)
        (activity as MainViewModelUtil).run {
            setVisibilityBottomAppbar(View.GONE)
        }
        (activity as MainViewModelUtil).run {
            setVisibilityTopAppBar(View.GONE)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPager2.let {
            it.adapter = OnBoardingViewPagerAdapter(this)
            binding.indicator.setViewPager(it)
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private inner class OnBoardingViewPagerAdapter(fragment: Fragment) :
        FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int = NUM_PAGES

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> OnBoarding1Fragment.newInstance()
                1 -> OnBoarding2Fragment.newInstance()
                else -> OnBoarding3Fragment.newInstance()
            }
        }
    }
}