package com.hackathon.co.kr.neopenproject

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.hackathon.co.kr.neopenproject.adapter.PagerAdapter
import com.hackathon.co.kr.neopenproject.databinding.ActivityMainBinding

import com.hackathon.co.kr.neopenproject.util.NetworkUtil

class MainActivity : AppCompatActivity() {

    private var networkUtil: NetworkUtil? = null
    var layoutResourceId = R.layout.activity_main
    lateinit var viewDataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this, layoutResourceId)
        networkUtil = NetworkUtil.getInstance()
        subscribeUI()
        getData()
    }

    fun subscribeUI(){
        viewDataBinding.tabView.addTab(viewDataBinding.tabView.newTab().setText("1"))
        viewDataBinding.tabView.addTab(viewDataBinding.tabView.newTab().setText("2"))
//        viewDataBinding.tabView.setTabsFromPagerAdapter(PagerAdapter(supportFragmentManager, 0))

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


    companion object {

        internal val TAG = "MainActivity"
    }
}
