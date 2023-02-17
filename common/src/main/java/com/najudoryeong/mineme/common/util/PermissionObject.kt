package com.najudoryeong.mineme.common.util

import android.Manifest


enum class PermissionType(val permissionArray: Array<String>) {
    GPS(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)),
    CAMERA(arrayOf(Manifest.permission.CAMERA)),
    NOTIFICATION(arrayOf(Manifest.permission.POST_NOTIFICATIONS))
}