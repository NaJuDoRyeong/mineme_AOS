package com.najudoryeong.mineme.common_ui

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController

// fragment 공통 init 부분 설정
abstract class BaseFragment<T : ViewDataBinding>(val fragment: FragmentInfoUtil) : Fragment() {
    private var _binding: T? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, fragment.layoutID, container, false)
        //activity는 MainActivity를 가르킴
        //MainViewModelUtil 통해 MainViewModel 코드에 접근
        (activity as MainViewModelUtil).run {
            setToolbarTitle(getString(fragment.toolbarText))
        }
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initMenu()
    }


    private fun initMenu() {
        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {

            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(fragment.menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                val navController = findNavController()

                /**
                 *
                with(navController) {
                when (menuItem.itemId) {
                android.R.id.home -> {
                popBackStack()
                }
                R.id.menu_ProfileSetting -> {
                navigate(R.id.action_homeFragment_to_profileSettingFragment)
                }
                R.id.menu_WritingStory -> {
                navigate(R.id.action_storyFragment_to_writingStoryFragment)
                }
                else -> {}
                }
                }
                 */

                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

}