package com.hackathon.co.kr.neopenproject.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hackathon.co.kr.neopenproject.MainActivity
import com.hackathon.co.kr.neopenproject.R
import com.hackathon.co.kr.neopenproject.adapter.RecyclerViewAdapter
import com.hackathon.co.kr.neopenproject.base.BaseActivity
import com.hackathon.co.kr.neopenproject.databinding.ActivityLoginBinding
import com.hackathon.co.kr.neopenproject.databinding.ActivityMainBinding
import com.hackathon.co.kr.neopenproject.ui.main.MainActivityViewModel
import com.hackathon.co.kr.neopenproject.util.NetworkUtil
import com.hackathon.co.kr.neopenproject.util.SharedUtil
import com.hackathon.co.kr.neopenproject.vo.ResponseVO

class LoginActivity : BaseActivity() {
    override var layoutResource: Int = R.layout.activity_login

    private var networkUtil: NetworkUtil? = null
    lateinit var viewDataBinding: ActivityLoginBinding
    val viewModel: MainActivityViewModel by lazy{
        ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkUtil = NetworkUtil.getInstance()
        subscribeUI()
    }

    fun subscribeUI(){
        viewModel.loginMessage.observe(this, Observer {
            if(!it.equals(SharedUtil.TOKEN_DEFAULT_VALUE)){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        })

        viewModel.toastMessage.observe(this, Observer{
            if(it.equals("goAssign")){
                val intent = Intent(this, AssignActivity::class.java)
                startActivity(intent)
            }
        })


    }


    override fun onDataBind() {
        viewDataBinding = DataBindingUtil.setContentView(this, layoutResource)
        viewDataBinding.activity = this
        viewDataBinding.loginVM = viewModel
    }

    override fun getIsUseDataBinding(): Boolean {
        return true
    }



    companion object {

        internal val TAG = "LoginActivity"
    }
}
