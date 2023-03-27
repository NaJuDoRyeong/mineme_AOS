package com.najudoryeong.mineme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.najudoryeong.mineme.common_ui.MainActivityUtil
import com.najudoryeong.mineme.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import com.najudoryeong.mineme.home.ui.HomeFragment
import com.najudoryeong.mineme.setting.fragment.ui.SettingFragment
import com.najudoryeong.mineme.story.ui.StoryFragment


// 하위 모듈이 MainViewModel 코드에 접근할 수 있게 MainViewModelUtil 상속 구현
@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainActivityUtil {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private val mainViewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = mainViewModel

        initAppBar()
        initBottomNav()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun initBottomNav() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_containerView) as NavHostFragment
        navController = navHostFragment.navController

        // appbar 구성 요소 설정
        // 바텀네비게이션과 연결하면 해당 프래그먼트에 네비게이션으로는 backButton x
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.nav_home, com.najudoryeong.mineme.story.R.id.storyFragment, R.id.nav_setting)
        )

        // navController 와 actionbar 연결
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        NavigationUI.setupActionBarWithNavController(this, navController)
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


    private fun showAppBar() {
        binding.bottomAppBar.visibility = View.VISIBLE
        binding.topAppBar.visibility = View.VISIBLE
    }


    /** [MainActivityUtil] */
    override fun setToolbarTitle(newTitle: String) {
        binding.toolbar.title = newTitle
    }


    override fun setVisibilityBottomAppbar(visibilityMode: Int) {
        binding.bottomAppBar.visibility = visibilityMode
    }

    override fun setVisibilityTopAppBar(visibilityMode: Int) {
        binding.topAppBar.visibility = visibilityMode
    }


}