package com.hackathon.co.kr.neopenproject.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity : AppCompatActivity() {
    private val isUseDataBinding = getIsUseDataBinding()

    abstract var layoutResource: Int
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(isUseDataBinding)
            onDataBind()
        else
            setContentView(layoutResource)
    }

    fun subScribeUI() {

    }


    abstract fun onDataBind()

    abstract fun getIsUseDataBinding(): Boolean
}