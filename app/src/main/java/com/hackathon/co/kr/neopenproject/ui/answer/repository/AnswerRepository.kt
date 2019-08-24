package com.hackathon.co.kr.neopenproject.ui.answer.repository

import com.hackathon.co.kr.neopenproject.util.NetworkUtil
import com.hackathon.co.kr.neopenproject.vo.AnswerVO

class AnswerRepository {
    fun getAnswer(id:Int, onSuccess: (AnswerVo: AnswerVO) -> Unit, onFailure: (t: Throwable) -> Unit){
        val networkUtil = NetworkUtil.getInstance()
        networkUtil.getAnswer(
                id,
                onSuccess = {
                    onSuccess(it)
                },
                onFailure = {
                    onFailure(it)
                }
        )
    }
}