package com.jfalstaff.singitout.presentation.glide

import android.view.View
import android.widget.ImageView

interface LoadImage {
    fun load(viewContainer: View, url: String?, imageView: ImageView)
    fun loadCircleCrop(viewContainer: View, url: String?, imageView: ImageView)
}