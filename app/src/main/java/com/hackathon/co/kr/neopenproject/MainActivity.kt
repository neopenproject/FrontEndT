package com.hackathon.co.kr.neopenproject

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.hackathon.co.kr.neopenproject.adapter.PagerAdapter
import com.hackathon.co.kr.neopenproject.base.BaseActivity
import com.hackathon.co.kr.neopenproject.databinding.ActivityMainBinding
import com.hackathon.co.kr.neopenproject.ui.main.MainActivityViewModel

import com.hackathon.co.kr.neopenproject.util.NetworkUtil

class MainActivity : BaseActivity() {
    override var layoutResource: Int = R.layout.activity_main

    private var networkUtil: NetworkUtil? = null
    lateinit var viewDataBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkUtil = NetworkUtil.getInstance()
        subscribeUI()
        getData()
    }

    fun subscribeUI(){

    }

    fun getData(){
        networkUtil!!.getTest(
                onSuccess = {
                    Log.e(TAG, it.code.toString())
                },
                onFailure = {
                    Log.e(TAG, it.toString())
                }
        )

    }

    override fun onDataBind() {
        viewDataBinding = DataBindingUtil.setContentView(this, layoutResource)
    }

    override fun getIsUseDataBinding(): Boolean {
        return true
    }



    companion object {

        internal val TAG = "MainActivity"
    }
}
