@file:JvmName("ExtensionsUtils")

package com.example.juliadart.redditcodechallenge

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ViewGroup.inflate(layoutId: Int): View {
        return LayoutInflater.from(context).inflate(layoutId, this, false)
    }

fun ImageView.loadImg(imageUrl: String) {
    if (TextUtils.isEmpty(imageUrl)) {
        Picasso.get().load(R.mipmap.ic_launcher).into(this)
    } else {
        Picasso.get().load(imageUrl).into(this)
    }
}
