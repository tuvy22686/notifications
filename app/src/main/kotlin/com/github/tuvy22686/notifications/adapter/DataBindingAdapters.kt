package com.github.tuvy22686.notifications.adapter

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import android.graphics.drawable.Drawable

class DataBindingAdapters {

    companion object {

        @JvmStatic
        @BindingAdapter("android:src")
        fun setImageUri(view: ImageView, imageUri: String?) {
            if (imageUri == null) {
                view.setImageURI(null)
            } else {
                view.setImageURI(Uri.parse(imageUri))
            }
        }

        @JvmStatic
        @BindingAdapter("android:src")
        fun setImageUri(view: ImageView, imageUri: Uri) {
            view.setImageURI(imageUri)
        }

        @JvmStatic
        @BindingAdapter("android:src")
        fun setImageDrawable(view: ImageView, drawable: Drawable) {
            view.setImageDrawable(drawable)
        }

        @JvmStatic
        @BindingAdapter("android:src")
        fun setImageResource(imageView: ImageView, src: Int) {
            imageView.setImageResource(src)
        }
    }
}
