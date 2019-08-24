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
import com.hackathon.co.kr.neopenproject.vo.CourseVO
import com.hackathon.co.kr.neopenproject.vo.ResponseVO
import kotlinx.android.synthetic.main.activity_main.*

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
        val list = ArrayList<CourseVO>()
        list.add(CourseVO("1", R.drawable.group_2))
        list.add(CourseVO("2", R.drawable.group_3))
        list.add(CourseVO("3", R.drawable.group_2_copy))
        list.add(CourseVO("4", R.drawable.group_3_copy))

        adapter.replaceAll(list)
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
        viewDataBinding
    }

    override fun getIsUseDataBinding(): Boolean {
        return true
    }



    companion object {

        internal val TAG = "MainActivity"
    }
}
