package com.hackathon.co.kr.neopenproject.util

import com.hackathon.co.kr.neopenproject.network.RetrofitInterface
import com.hackathon.co.kr.neopenproject.network.RetrofitServer
import com.hackathon.co.kr.neopenproject.vo.ProblemVO
import com.hackathon.co.kr.neopenproject.vo.AnswerVO
import com.hackathon.co.kr.neopenproject.vo.ResponseVO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkUtil {
    var TAG = "NetworkUtil"
    lateinit var networkInterface: RetrofitInterface

    companion object {
        fun getInstance(): NetworkUtil {
            val networkUtil = NetworkUtil()
            networkUtil.networkInterface = RetrofitServer.getInstance()
            return networkUtil
        }
    }

    fun getTest(onSuccess: (responseVo: ResponseVO) -> Unit, onFailure: (t: Throwable) -> Unit) {
        var returnValue: ResponseVO = ResponseVO()
        val getT = networkInterface.get_userLogin()
        getT.enqueue(object : Callback<ResponseVO> {
            override fun onFailure(call: Call<ResponseVO>, t: Throwable) {
                onFailure(t)
            }

            override fun onResponse(call: Call<ResponseVO>, response: Response<ResponseVO>) {
                returnValue = response.body()!!
                onSuccess(returnValue)
            }
        })
    }

    fun postSignup(email: String, pwd: String, onSuccess: (responseVo: ResponseVO) -> Unit, onFailure: (t: Throwable) -> Unit) {
        var returnValue: ResponseVO = ResponseVO()
        val getT = networkInterface.post_userSinup(email, pwd)
        getT.enqueue(object : Callback<ResponseVO> {
            override fun onFailure(call: Call<ResponseVO>, t: Throwable) {
                onFailure(t)
            }

            override fun onResponse(call: Call<ResponseVO>, response: Response<ResponseVO>) {
                returnValue = response.body()!!
                onSuccess(returnValue)
            }
        })
    }

    fun postLogin(email: String, pwd: String, onSuccess: (responseVo: ResponseVO) -> Unit, onFailure: (t: Throwable) -> Unit) {
        var returnValue: ResponseVO = ResponseVO()
        val getT = networkInterface.post_userLogin(email, pwd)
        getT.enqueue(object : Callback<ResponseVO> {
            override fun onFailure(call: Call<ResponseVO>, t: Throwable) {
                onFailure(t)
            }

            override fun onResponse(call: Call<ResponseVO>, response: Response<ResponseVO>) {
                returnValue = response.body()!!
                if (returnValue != null)
                    onSuccess(returnValue)
            }
        })
    }

    fun getAnswerPost(onSuccess: (responseVo: ProblemVO) -> Unit, onFailure: (t: Throwable) -> Unit) {
        val getAnswers = networkInterface.getAnswerPost()
        getAnswers.enqueue(object : Callback<ProblemVO> {
            override fun onFailure(call: Call<ProblemVO>, t: Throwable) {
                onFailure(t)
            }

            override fun onResponse(call: Call<ProblemVO>, response: Response<ProblemVO>) {
                response.body()?.apply {
                    onSuccess(this)
                }
            }
        })
    }

    fun getAnswer(id:Int, onSuccess: (AnswerVo: AnswerVO) -> Unit, onFailure: (t: Throwable) -> Unit){
        val getT = networkInterface.get_answer(id)
        getT.enqueue(object : Callback<AnswerVO> {
            override fun onFailure(call: Call<AnswerVO>, t: Throwable) {
                onFailure(t)
            }

            override fun onResponse(call: Call<AnswerVO>, response: Response<AnswerVO>) {
                var returnValue = response.body()!!
                if (returnValue != null)
                    onSuccess(returnValue)
            }
        })
    }
}