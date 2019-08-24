package com.hackathon.co.kr.neopenproject.adapter

import android.text.InputType
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.hackathon.co.kr.neopenproject.R

@BindingAdapter("typeSetting")
fun setEditTextInputType(view: EditText, type: Int) {
    when (type) {
        0 -> {
            view.inputType = InputType.TYPE_CLASS_TEXT
        }
        else -> {
            view.transformationMethod = PasswordTransformationMethod.getInstance()
        }
    }

    view.requestLayout()
}

@BindingAdapter("android:src")
fun setSrc(view: ImageView, url: Int) {
    Log.d("url ", url.toString())

    Glide.with(view.context).load(url).into(view)
}

@BindingAdapter("android:visibility")
fun setVisibility(view: View, isVisible: Boolean) {
    Log.d("setVisibility ", "$isVisible")
    if(isVisible)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE

    view.requestLayout()
}