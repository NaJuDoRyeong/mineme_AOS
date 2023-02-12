package com.najudoryeong.mineme.common_ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("photoUrl")
fun bindImageView(imageView: ImageView, photoUrl: String?) {
    Glide.with(imageView.context)
        .load(photoUrl)
        .placeholder(R.drawable.img_profile)
        .into(imageView)
}

