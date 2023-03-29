package com.najudoryeong.mineme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.najudoryeong.mineme.common_ui.MainActivityUtil
import com.najudoryeong.mineme.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import com.najudoryeong.mineme.home.R.navigation.nav_home
import com.najudoryeong.mineme.story.R.navigation.nav_story
import com.najudoryeong.mineme.setting.R.navigation.nav_setting


// 하위 모듈이 MainViewModel 코드에 접근할 수 있게 MainViewModelUtil 상속 구현
@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainActivityUtil {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var appBarConfiguration: AppBarConfiguration


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
        val inflater = navController.navInflater
        val configuration = AppBarConfiguration(
            setOf(
                com.najudoryeong.mineme.home.R.id.homeFragment,
                com.najudoryeong.mineme.setting.R.id.settingFragment
            )
        )
        NavigationUI.setupActionBarWithNavController(this, navController,configuration)

        binding.bottomNavigationView.run {
            setupWithNavController(navController)
            itemIconTintList = null
        }

        binding.bottomNavigationView.setOnItemSelectedListener {
            navHostFragment.navController.graph = when (it.itemId) {
                R.id.nav_home -> inflater.inflate(nav_home)
                R.id.nav_story -> inflater.inflate(nav_story)
                else -> inflater.inflate(nav_setting)
            }
            true
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