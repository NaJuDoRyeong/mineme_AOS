package com.najudoryeong.mineme.common.util

/** Login 진행 상황 상태를 저장 위한 클래스 입니다. **/
enum class LoginState(val s: String) {
    ONBOARDING("onboarding"), LOGIN("login"), USERINFO("userinfo"), CODE("code"), FINISH("finish")
}