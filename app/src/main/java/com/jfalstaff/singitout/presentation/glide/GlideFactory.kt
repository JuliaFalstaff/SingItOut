package com.jfalstaff.singitout.presentation.glide

import android.graphics.Bitmap
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
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

    override fun loadPaletteColorBackground(viewContainer: View, url: String?, imageView: ImageView) {
        GlideApp.with(viewContainer)
            .asBitmap()
            .load(url)
            .listener(object : RequestListener<Bitmap> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Bitmap>?,
                    isFirstResource: Boolean
                ): Boolean {
                    Log.d("Palette", "error: ${e?.stackTraceToString()}")
                    return false
                }

                override fun onResourceReady(
                    resource: Bitmap?,
                    model: Any?,
                    target: Target<Bitmap>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    if (resource != null) {
                        val palette: Palette = Palette.from(resource).generate()
                        val color = palette.darkMutedSwatch?.rgb ?: R.color.teal_200
                        imageView.setBackgroundColor(color)
                    }
                    return true
                }
            })
            .into(imageView)
    }
}