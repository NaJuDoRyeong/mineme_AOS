package com.najudoryeong.mineme

import android.app.Application
import android.util.Log
import com.example.common.util.NATIVE_APP_KEY
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.util.Utility
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MineMeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, NATIVE_APP_KEY)
        //printAppKeyHash()
    }

    private fun printAppKeyHash() {
        val keyHash = Utility.getKeyHash(this)
        Log.d("KeyHash", keyHash)
    }
}