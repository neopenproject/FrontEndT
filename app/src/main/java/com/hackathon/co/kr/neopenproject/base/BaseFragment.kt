package com.hackathon.co.kr.neopenproject.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    private val layoutRes = getLayoutRes()
    private val isUseDataBinding = getIsUseDataBinding()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)

        return if (layoutRes > -1) {
            if (isUseDataBinding)
                onDataBinding(inflater, container!!)
            else
                inflater.inflate(layoutRes, container, false)
        } else super.onCreateView(inflater, container, savedInstanceState)

    }

    fun onDataBinding(inflater: LayoutInflater, container: ViewGroup): View? {
        return null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subScribeUI()
    }

    // livedata 있는 경우 observe 설정
    fun subScribeUI() {

    }

    abstract fun getLayoutRes(): Int
    abstract fun getIsUseDataBinding(): Boolean
}