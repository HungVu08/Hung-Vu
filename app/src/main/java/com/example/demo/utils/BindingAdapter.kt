package com.example.demo.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapter {
    @BindingAdapter("loadUrlImage")
    @JvmStatic
    fun ImageView.loadImage(url : String){
        Glide.with(context).load(url).into(this)
    }
}