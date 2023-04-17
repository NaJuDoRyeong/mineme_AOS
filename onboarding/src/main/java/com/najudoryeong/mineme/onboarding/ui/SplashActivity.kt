package com.najudoryeong.mineme.onboarding.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.najudoryeong.mineme.common.util.LoginState
import com.najudoryeong.mineme.onboarding.util.LoginUtil
import com.najudoryeong.mineme.onboarding.R
import com.najudoryeong.mineme.onboarding.databinding.ActivitySplashBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var mainActivityClass: Class<*>

    private lateinit var navController: NavController
    private lateinit var binding: ActivitySplashBinding
    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        checkJWT()
    }

    /** 기기에 JWT가 있는지 검사합니다.
    --> JWT가 있다면 MainActivity로 이동
    --> JWT가 없다면 온보딩을 시작합니다.
     **/
    private fun checkJWT() {
        splashViewModel.withLoginState { s ->
            Log.d("state",s.toString())
            val nav = if (s == null) {
                splashViewModel.editLoginState(LoginState.ONBOARDING)
                R.id.onBoardingViewPagerFragment
            } else {
                when (s) {
                    "onboarding" -> {
                        R.id.onBoardingViewPagerFragment
                    }
                    "login" -> {
                        R.id.loginFragment
                    }
                    "userinfo"
                    -> {
                        R.id.inputUserInfoFragment
                    }
                    "code"
                    -> {
                        R.id.inputCodeFragment
                    }
                    "finish"
                    -> {
                        LoginUtil.startMainActivity(this, mainActivityClass)
                        -1
                    }
                    else -> {
                        -1
                    }
                }
            }
            initNav(nav)
        }
    }

    private fun initNav(nav: Int) {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_containerView) as NavHostFragment
        navController = navHostFragment.navController
        binding.fragmentContainerView.visibility = View.VISIBLE
        settingNav(nav)
    }

    private fun settingNav(nav: Int) {
        if (nav == -1) return
        findNavController(R.id.fragment_containerView).navigate(nav)
    }


}