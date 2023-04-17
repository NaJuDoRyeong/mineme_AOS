package com.najudoryeong.mineme.onboarding.ui

import android.annotation.SuppressLint
import android.os.Bundle
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
        initNav()
        checkJWT()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
    }

    /** 기기에 JWT가 있는지 검사합니다.
    --> JWT가 있다면 MainActivity로 이동
    --> JWT가 없다면 온보딩을 시작합니다.
     **/
    private fun checkJWT() {
        splashViewModel.withLoginState { s ->
            val nav = if (s == null) {
                R.id.onBoardingViewPagerFragment
            } else {
                when (LoginState.valueOf(s)) {
                    LoginState.ONBOARDING -> {
                        R.id.onBoardingViewPagerFragment
                    }
                    LoginState.LOGIN -> {
                        R.id.loginFragment
                    }
                    LoginState.USERINFO
                    -> {
                        R.id.inputUserInfoFragment
                    }
                    LoginState.CODE
                    -> {
                        R.id.inputCodeFragment
                    }
                    LoginState.FINISH
                    -> {
                        LoginUtil.startMainActivity(this, mainActivityClass)
                        -1
                    }
                }
            }
            settingNav(nav)
        }
    }

    private fun initNav() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_containerView) as NavHostFragment
        navController = navHostFragment.navController
        binding.fragmentContainerView.visibility = View.VISIBLE
    }

    private fun settingNav(nav: Int) {
        if (nav == -1) return
        findNavController(R.id.fragment_containerView).navigate(nav)
    }


}