package com.hackathon.co.kr.neopenproject.ui.main

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hackathon.co.kr.neopenproject.CustomApplication
import com.hackathon.co.kr.neopenproject.R
import com.hackathon.co.kr.neopenproject.ui.main.repository.MainRepository
import com.hackathon.co.kr.neopenproject.ui.main.repository.MainRepositoryImpl
import com.hackathon.co.kr.neopenproject.util.SharedUtil
import com.hackathon.co.kr.neopenproject.vo.ResponseVO

open class MainActivityViewModel (app: Application) : AndroidViewModel(app) {

    var titles = app.resources.getStringArray(R.array.assign_titles)
    var inputs = arrayListOf(
            ObservableField(""), ObservableField(""), ObservableField(""), ObservableField(""),
            ObservableField(""), ObservableField(""), ObservableField(""), ObservableField("")
    )
    var toastMessage = MutableLiveData<String>()

    var loginMessage = MutableLiveData<String>()
    var signUpMsg = MutableLiveData<String>()
    var responseVO = MutableLiveData<ResponseVO>()
    var mainRepositoryImpl: MainRepository

    init {
        mainRepositoryImpl = MainRepositoryImpl()

        getTest()
    }

    fun getTest() {
        mainRepositoryImpl.getTest(
                onSuccess = {
                    responseVO.value = it
                },
                onFailure = {
                    Log.e("MainViewModel", it.message)
                }
        )
    }

    fun logIn(email: String, pwd: String) {
        val token = SharedUtil.getStringData(SharedUtil.TOKEN_KEY)
        if (token.equals(SharedUtil.TOKEN_DEFAULT_VALUE)) {

            mainRepositoryImpl.postLogin(
                    email, pwd,
                    onSuccess = {
                        if (it.code.equals("00"))
                        // 1. sharedpreference에 저장한다.
                        loginMessage.value = it.result
                        SharedUtil.setData(SharedUtil.TOKEN_KEY, it.result)

                    },
                    onFailure = {
                        Log.e("MainViewModel", it.message)
                        loginMessage.value = "로그인 실패"
                    }
            )
        } else{
            loginMessage.value = token
        }

    }

    fun postSignup(email: String, pwd: String) {
        mainRepositoryImpl.postSignup(
                email, pwd,
                onSuccess = {
                    if (it.code.equals("00"))
                        signUpMsg.value = it.result
                    else
                        signUpMsg.value = "fail"
                },
                onFailure = {
                    Log.e("MainViewModel", it.message)
                }
        )
    }

    fun assignBtnClick(isAssign: Boolean) {
        val id = inputs[0].get() ?: ""
        val pw = inputs[1].get() ?: ""

        if (isAssign) {
            Log.d("assignBtnClick : ", "$id, $pw")

            postSignup(id, pw)
            // 회원가입 로직 넣으면 됩니다.
        } else {
            Log.d("assignBtnClick : ", "$id, $pw")
            toastMessage.value = "goAssign"
        }
    }

    fun loginBtnClick() {
        val id = inputs[0].get() ?: ""
        val pw = inputs[1].get() ?: ""

        Log.d("loginBtnClick : ", "$id, $pw")
        // 로그인 화면에서 로그인 로직 넣으면 됩니다.
        logIn(id, pw)
    }

}