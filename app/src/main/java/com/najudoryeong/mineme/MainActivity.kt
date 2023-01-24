package com.najudoryeong.mineme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.najudoryeong.mineme.common_ui.MainActivityUtil
import com.najudoryeong.mineme.databinding.ActivityMainBinding


// 하위 모듈이 MainViewModel 코드에 접근할 수 있게 MainViewModelUtil 상속 구현
class MainActivity : AppCompatActivity(), MainActivityUtil {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    private val model: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = model

        initAppBar()
        initBottomNav()

        setStartDestination(isLogin())

    }


    /**
     * login 여부에 따른 startDestination 조작을 위해
     * main graph를 가져와서 startDestination을 조작 후 변경내용을 적용한다.
     * */

    private fun setStartDestination(isLogin: Boolean) {
        val navGraph = navController.navInflater.inflate(R.navigation.nav_main)
        if (isLogin) navGraph.setStartDestination(R.id.nav_home)
        else navGraph.setStartDestination(com.najudoryeong.mineme.onboarding.R.id.nav_onboarding)
        navController.setGraph(navGraph, null)
    }

    // todo 로그인 체크 로직
    private fun isLogin(): Boolean {
        return true
    }

    private fun initBottomNav() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_containerView) as NavHostFragment
        navController = navHostFragment.navController

        // appbar 구성 요소 설정
        // 바텀네비게이션과 연결하면 해당 프래그먼트에 네비게이션으로는 backButton x
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.nav_home, R.id.nav_setting, R.id.nav_setting)
        )

        // navController 와 actionbar 연결
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


    private fun showAppBar() {
        binding.bottomAppBar.visibility = View.VISIBLE
        binding.fab.visibility = View.VISIBLE
        binding.topAppBar.visibility = View.VISIBLE
    }

    /** [MainActivityUtil] */
    override fun setToolbarTitle(newTitle: String) {
        binding.toolbar.title = newTitle
    }

    override fun navigateToHome(start: Fragment) {
        start.findNavController().navigate(R.id.nav_home)
        showAppBar()
    }

    override fun setVisibilityBottomAppbar(visibilityMode: Int) {
        binding.bottomAppBar.visibility = visibilityMode
        binding.fab.visibility = visibilityMode
    }

    override fun setVisibilityTopAppBar(visibilityMode: Int) {
        binding.topAppBar.visibility = visibilityMode
    }

}