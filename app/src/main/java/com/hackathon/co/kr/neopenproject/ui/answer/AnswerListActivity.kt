package com.hackathon.co.kr.neopenproject.ui.answer

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.JsonArray
import com.hackathon.co.kr.neopenproject.R
import com.hackathon.co.kr.neopenproject.adapter.AnswerRecyclerViewAdapter
import com.hackathon.co.kr.neopenproject.base.BaseActivity
import com.hackathon.co.kr.neopenproject.databinding.ActivityAnswerlistBinding
import com.hackathon.co.kr.neopenproject.util.NetworkUtil
import com.hackathon.co.kr.neopenproject.vo.AnswerDTO

class AnswerListActivity : BaseActivity(){
    override var layoutResource: Int = R.layout.activity_answerlist

    private var networkUtil: NetworkUtil? = null
    lateinit var viewDataBinding: ActivityAnswerlistBinding
    val viewModel: AnswerViewModel by lazy{
        ViewModelProviders.of(this).get(AnswerViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkUtil = NetworkUtil.getInstance()
        subscribeUI()
    }

    fun subscribeUI(){
        viewDataBinding.rvAnswerList.layoutManager = GridLayoutManager(this,2) as RecyclerView.LayoutManager?
        val adapter = AnswerRecyclerViewAdapter(this)
        viewDataBinding.rvAnswerList.adapter = adapter

        viewModel.answer.observe(this, Observer {
            val result = it.result?.get("answer_post")as JsonArray

//            viewDataBinding.tvCnt.text = (it.result?.get("count") as JsonArray).asString
            val list = ArrayList<AnswerDTO>()
            result.forEach{
                val item = it.asJsonObject
                val update = item.get("updated_at").asString
                list.add(AnswerDTO("http://ec2-15-164-171-69.ap-northeast-2.compute.amazonaws.com/api/v1/"+item.get("answer_img").asString, item.get("is_teacher_view").asBoolean, update))
            }
            adapter.replaceAll(list)
        })

        viewModel.getAnswerList(1)

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

        internal val TAG = "AnswerListActivity"
    }
}