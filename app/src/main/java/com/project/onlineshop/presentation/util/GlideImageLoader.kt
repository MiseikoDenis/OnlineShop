package com.project.onlineshop.presentation.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.project.domain.ImageLoader

object GlideImageLoader : ImageLoader {

    override fun loadImage(imageUrl: String, imageView: ImageView) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .into(imageView)
    }
}