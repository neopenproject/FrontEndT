package com.hackathon.co.kr.neopenproject.util

import android.util.Log
import com.hackathon.co.kr.neopenproject.network.RetrofitInterface
import com.hackathon.co.kr.neopenproject.network.RetrofitServer
import com.hackathon.co.kr.neopenproject.vo.DataVO
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

    fun getTest(onSuccess:(dataVo:DataVO) -> Unit, onFailure:(t:Throwable) -> Unit){
        var returnValue: DataVO = DataVO()
        val getT = networkInterface.get_userLogin()
        getT.enqueue(object : Callback<DataVO> {
            override fun onFailure(call: Call<DataVO>, t: Throwable) {
                onFailure(t)
            }

            override fun onResponse(call: Call<DataVO>, response: Response<DataVO>) {
                returnValue = response.body()!!
                onSuccess(returnValue)
            }
        })
    }
}