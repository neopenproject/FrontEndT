package com.hackathon.co.kr.neopenproject.ui.main.repository

import com.hackathon.co.kr.neopenproject.util.NetworkUtil
import com.hackathon.co.kr.neopenproject.vo.ResponseVO

class MainRepositoryImpl() : MainRepository {
    override fun postLogin(email: String, pwd: String, onSuccess: (responseVo: ResponseVO) -> Unit, onFailure: (t: Throwable) -> Unit) {
        val networkUtil = NetworkUtil.getInstance()
        networkUtil.postLogin(
                email,
                pwd,
                onSuccess = {
                    onSuccess(it)
                },
                onFailure = {
                    onFailure(it)
                }
        )
    }

    override fun postSignup(email: String, pwd: String, onSuccess: (responseVo: ResponseVO) -> Unit, onFailure: (t: Throwable) -> Unit) {
        val networkUtil = NetworkUtil.getInstance()
        networkUtil.postSignup(
                email,
                pwd,
                onSuccess = {
                    onSuccess(it)
                },
                onFailure = {
                    onFailure(it)
                }
        )
    }

    override fun getTest(onSuccess: (responseVo: ResponseVO) -> Unit, onFailure: (t: Throwable) -> Unit) {
        val networkUtil = NetworkUtil.getInstance()
        networkUtil.getTest(
                onSuccess = {
                    onSuccess(it)
                },
                onFailure = {
                    onFailure(it)
                }
        )
    }
}