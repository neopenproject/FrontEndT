package com.hackathon.co.kr.neopenproject

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hackathon.co.kr.neopenproject.adapter.RecyclerViewAdapter
import com.hackathon.co.kr.neopenproject.base.BaseActivity
import com.hackathon.co.kr.neopenproject.databinding.ActivityMainBinding
import com.hackathon.co.kr.neopenproject.ui.main.MainActivityViewModel

import com.hackathon.co.kr.neopenproject.util.NetworkUtil
import com.hackathon.co.kr.neopenproject.vo.ResponseVO

class MainActivity : BaseActivity() {
    override var layoutResource: Int = R.layout.activity_main

    private var networkUtil: NetworkUtil? = null
    lateinit var viewDataBinding: ActivityMainBinding
    val viewModel: MainActivityViewModel by lazy{
        ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkUtil = NetworkUtil.getInstance()
        subscribeUI()
    }

    fun subscribeUI(){
        viewDataBinding.rvMain.layoutManager = GridLayoutManager(this,2) as RecyclerView.LayoutManager?
        val adapter = RecyclerViewAdapter(this)
        viewDataBinding.rvMain.adapter = adapter

        viewModel.responseVO.observe(this, Observer {
            val list = ArrayList<ResponseVO>()
            list.add(it)
            list.add(ResponseVO())
            adapter.replaceAll(list)
        })


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
