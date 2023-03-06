package com.example.myappbms.utils

import android.widget.ImageView
import com.bumptech.glide.Glide


fun ImageView.loadImage(url: String) {
//    Picasso.get().load(url).into(this)
    Glide.with(this).load(url).into(this)

}