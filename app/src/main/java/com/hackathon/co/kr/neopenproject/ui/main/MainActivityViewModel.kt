package com.hackathon.co.kr.neopenproject.ui.main

import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hackathon.co.kr.neopenproject.ui.main.repository.MainRepository
import com.hackathon.co.kr.neopenproject.ui.main.repository.MainRepositoryImpl
import com.hackathon.co.kr.neopenproject.vo.ResponseVO

class MainActivityViewModel : ViewModel() {

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

    fun logIn(email: String, pwd: String){
        mainRepositoryImpl.postLogin(
                email, pwd,
                onSuccess = {
                    loginMessage.value = it.result.get("token").asString
                },
                onFailure = {
                    Log.e("MainViewModel", it.message)
                }
        )

    }

    fun postSignup(email: String, pwd: String){
        mainRepositoryImpl.postSignup(
                email,pwd,
                onSuccess = {
                    signUpMsg.value = it.result.get("token").asString
                },
                onFailure = {
                    Log.e("MainViewModel", it.message)
                }
        )
    }

}