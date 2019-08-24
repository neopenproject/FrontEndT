package com.hackathon.co.kr.neopenproject.ui.answer

import android.content.Intent
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
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

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

        val intent = intent

        subscribeUI(intent)
    }

    fun subscribeUI(intent: Intent){
        viewDataBinding.rvAnswerList.layoutManager = GridLayoutManager(this,2) as RecyclerView.LayoutManager?
        val adapter = AnswerRecyclerViewAdapter(this)
        viewDataBinding.rvAnswerList.adapter = adapter

        val title = intent.getStringExtra("title")
        val subject = intent.getStringExtra("subject")
        val id = intent.getIntExtra("id",1)

        viewDataBinding.btnBack.setOnClickListener {
            finish()
        }
        viewDataBinding.tvAnswerObj.text = title
        viewDataBinding.tvAnswerObjSub.text = subject
        viewModel.answer.observe(this, Observer {
            val result = it.result?.get("answer_post")as JsonArray

//            viewDataBinding.tvCnt.text = (it.result?.get("count") as JsonArray).asString
            val list = ArrayList<AnswerDTO>()
            result.forEach{
                val item = it.asJsonObject
                val unixSeconds = item.get("updated_at").asLong
                val date = Date(unixSeconds/10000)
                val sdf = SimpleDateFormat("yyyy.MM.dd")
                sdf.timeZone = TimeZone.getTimeZone("GMT-4")
                val update = sdf.format(date)
                list.add(AnswerDTO("http://ec2-15-164-171-69.ap-northeast-2.compute.amazonaws.com/api/v1/"+item.get("answer_img").asString, item.get("is_teacher_view").asBoolean, update))
            }
            adapter.replaceAll(list)
        })

        viewModel.getAnswerList(id)

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