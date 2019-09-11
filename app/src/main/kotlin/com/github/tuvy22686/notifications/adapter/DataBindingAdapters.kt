package com.github.tuvy22686.notifications.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object DataBindingAdapters {

    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageResource(imageView: ImageView, src: Int) {
        imageView.setImageResource(src)
    }
}
