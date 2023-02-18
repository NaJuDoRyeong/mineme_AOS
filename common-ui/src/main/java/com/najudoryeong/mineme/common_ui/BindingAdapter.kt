package com.najudoryeong.mineme.common_ui

import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


@BindingAdapter("photoUrl")
fun bindImageView(imageView: ImageView, photoUrl: String?) {
    Glide.with(imageView.context)
        .load(photoUrl)
        .placeholder(R.drawable.img_profile)
        .into(imageView)
}

@BindingAdapter("uri")
fun bindImageView(imageView: ImageView, uri: Uri?) {
    Glide.with(imageView.context)
        .load(uri)
        .into(imageView)
}

@BindingAdapter("visible")
fun setVisibility(view: View, flag: Boolean) {
    view.visibility = if (flag) View.VISIBLE else View.GONE
}

@BindingAdapter("adapter", "submitList", requireAll = true)
fun bindRecyclerView(view: RecyclerView, adapter: RecyclerView.Adapter<*>, submitList: List<Any>?) {
    view.adapter = adapter.apply {
        stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
        (this as ListAdapter<Any, *>).submitList(submitList?.toMutableList())
    }
}


