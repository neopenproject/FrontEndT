package com.hackathon.co.kr.neopenproject

import android.app.Application
import android.content.SharedPreferences
import com.hackathon.co.kr.neopenproject.util.NetworkUtil
import com.hackathon.co.kr.neopenproject.util.SharedUtil

class CustomApplication :Application(){
    override fun onCreate() {
        super.onCreate()

        SharedUtil.sharedPreferenceInit(applicationContext)
    }
}