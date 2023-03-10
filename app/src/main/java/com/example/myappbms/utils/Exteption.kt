package com.example.myappbms.utils

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide


fun ImageView.loadImage(url: String) {
//    Picasso.get().load(url).into(this)
    Glide.with(this).load(url).into(this)

}

fun Context.toast(msg:String){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}