package com.najudoryeong.mineme.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.najudoryeong.mineme.onboarding.databinding.ActivitySplashBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    /** inject from [MainModule] in AppModule */
    @Inject
    lateinit var mainActivityClass: Class<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        if (!checkAuth()) startOnBoarding()
        if (!checkLogin()) startLogin()
        startMainActivity()
    }

    // 권한 동의와 로그인이 됐다면 바로 홈 화면으로 이동 아니면 권한 및 로그인화면 이동
    private fun checkAuth(): Boolean {
        //todo 권한 체크
        return true
    }

    private fun checkLogin() : Boolean{
        //todo 로그인 체크
        return true
    }

    private fun startMainActivity() {
        val intent = Intent(this, mainActivityClass)
        startActivity(intent)
    }

    private fun startLogin(){
        //todo login 처리 프로세스
    }
    private fun startOnBoarding(){
        //todo onBoarding 프로세스
    }
}