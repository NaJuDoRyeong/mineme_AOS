package com.najudoryeong.mineme.common_ui

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController

abstract class BaseFragment<T : ViewDataBinding>(val fragment: FragmentInfoUtil) : Fragment() {
    private var _binding: T? = null
    val binding get() = _binding!!

    // baseFragment를 상속받은 fragment에서만 제한된 작업 initView 에서 진행
    abstract fun initView()

    open fun menuClick(){}
    open fun backClick() : Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, fragment.layoutID, container, false)
        //activity는 MainActivity를 가르킴
        //MainViewModelUtil 통해 MainViewModel 코드에 접근
        //todo methode
        (activity as MainActivityUtil).run {
            setToolbarTitle(getString(fragment.toolbarText))
        }

        setVisibilityNav()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
        initMenu()

    }

    private fun setVisibilityNav() {
        (activity as MainActivityUtil).run {
            setVisibilityBottomAppbar(fragment.bottomNavi_visibility)
        }
    }

    private fun initMenu() {
        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {

            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                if (fragment.menu != -1) {
                    menuInflater.inflate(fragment.menu, menu)
                }
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                val navController = findNavController()

                with(navController) {
                    when (menuItem.itemId) {
                        android.R.id.home -> {
                            if (!backClick()){
                                popBackStack()
                            }
                        }
                        else -> {
                            menuClick()
                        }
                    }
                }
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
}

