package com.najudoryeong.mineme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.najudoryeong.mineme.common_ui.MainViewModelUtil
import com.najudoryeong.mineme.databinding.ActivityMainBinding

// 하위 모듈이 MainViewModel 코드에 접근할 수 있게 MainViewModelUtil 상속 구현
class MainActivity : AppCompatActivity(), MainViewModelUtil {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private val model: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewModel = model
        model.toolbarTitle.observe(this, toolbarTitleObserver)

        initAppBar()
        initBottomNav()
    }

    private fun initBottomNav() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_containerView) as NavHostFragment
        val navController = navHostFragment.navController

        // appbar 구성 요소 설정
        // 바텀네비게이션과 연결하면 해당 프래그먼트에 네비게이션으로는 backButton x
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.home,R.id.story)
        )

        // navController와 actionbar 연결
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)

        binding.bottomNavigationView.run {
            setupWithNavController(navController)
            itemIconTintList = null
        }
    }

    private fun initAppBar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.run {
            setDisplayShowTitleEnabled(false) //title제거
            setDisplayHomeAsUpEnabled(true)
        }
    }

    /** [MainViewModelUtil] */
    override fun setToolbarTitle(newTitle: String) {
        model.updateToolbarTitle(newTitle)
    }

    //toolbar title 옵저버
    private val toolbarTitleObserver = Observer<String> {
        binding.toolbar.title = it
    }


}