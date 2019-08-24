package com.hackathon.co.kr.neopenproject.ui.main.repository

import com.hackathon.co.kr.neopenproject.vo.ResponseVO

interface MainRepository {
    fun getTest(onSuccess: (responseVo: ResponseVO) -> Unit, onFailure:(t:Throwable) -> Unit)

    fun postSignup(email:String, pwd: String, onSuccess: (responseVo: ResponseVO) -> Unit, onFailure:(t:Throwable) -> Unit)

    fun postLogin(email:String, pwd: String, onSuccess: (responseVo: ResponseVO) -> Unit, onFailure:(t:Throwable) -> Unit)

}