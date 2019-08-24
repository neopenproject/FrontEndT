package com.hackathon.co.kr.neopenproject.util

import com.hackathon.co.kr.neopenproject.network.RetrofitInterface
import com.hackathon.co.kr.neopenproject.network.RetrofitServer
import com.hackathon.co.kr.neopenproject.vo.ResponseVO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkUtil {
    var TAG ="NetworkUtil"
    lateinit var networkInterface : RetrofitInterface

    companion object {
        fun getInstance(): NetworkUtil {
            val networkUtil = NetworkUtil()
            networkUtil.networkInterface = RetrofitServer.getInstance()
            return networkUtil
        }
    }

    fun getTest(onSuccess:(responseVo:ResponseVO) -> Unit, onFailure:(t:Throwable) -> Unit){
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

    fun postSignup(email:String, pwd:String,onSuccess:(responseVo:ResponseVO) -> Unit, onFailure:(t:Throwable) -> Unit){
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

    fun postLogin(email:String, pwd:String,onSuccess:(responseVo:ResponseVO) -> Unit, onFailure:(t:Throwable) -> Unit){
        var returnValue: ResponseVO = ResponseVO()
        val getT = networkInterface.post_userLogin(email, pwd)
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
}