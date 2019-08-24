package com.hackathon.co.kr.neopenproject.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hackathon.co.kr.neopenproject.R
import com.hackathon.co.kr.neopenproject.databinding.ActivityAssignBinding
import com.hackathon.co.kr.neopenproject.ui.main.MainActivityViewModel

class AssignActivity : AppCompatActivity() {
    var layoutRes = R.layout.activity_assign
    lateinit var binding: ActivityAssignBinding
    val assignVM: MainActivityViewModel by lazy {
        ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
    }

    fun onDataBinding() {
        binding = DataBindingUtil.setContentView(this, layoutRes)
        binding.activity = this
        binding.assignVM = assignVM
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onDataBinding()
        subscribeUI()
    }

    fun subscribeUI(){
        assignVM.signUpMsg.observe(this, Observer {
            if(!it.equals("fail")){
                finish()
            }
        })

    }
}