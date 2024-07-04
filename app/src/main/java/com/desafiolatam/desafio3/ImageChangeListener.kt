package com.desafiolatam.desafio3

import android.view.View
import android.widget.ImageView

abstract class ImageChangeListener : View.OnClickListener {
    abstract val imageView: ImageView
    abstract val imageResource: Int

    override fun onClick(v: View?) {
        imageView.setImageResource(imageResource)
    }
}