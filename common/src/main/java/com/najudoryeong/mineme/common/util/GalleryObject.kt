package com.najudoryeong.mineme.common.util

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class GalleryObject {

    companion object {

        fun getImageResult(fragment: Fragment, callback: (Uri)->Unit): ActivityResultLauncher<Intent> {
            return fragment.registerForActivityResult(
                ActivityResultContracts.StartActivityForResult()
            ) { result ->
                if (result.resultCode == RESULT_OK) {
                    val imageUri = result.data?.data
                    callback.invoke(imageUri!!)
                }
            }
        }
    }
}