package com.jfalstaff.singitout.presentation.glide

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.jfalstaff.singitout.R

object GlideFactory: LoadImage {
    override fun load(viewContainer: View, url: String?,  imageView: ImageView) {
        Glide.with(viewContainer)
            .load(url)
            .placeholder(R.drawable.progress_animation)
            .into(imageView)
    }

    override fun loadCircleCrop(viewContainer: View, url: String?, imageView: ImageView) {
        Glide.with(viewContainer)
            .load(url)
            .circleCrop()
            .placeholder(R.drawable.progress_animation)
            .into(imageView)
    }
}