package com.hackathon.co.kr.neopenproject.network

import android.telecom.Call
import com.hackathon.co.kr.neopenproject.vo.DataVO
import retrofit2.http.GET
import retrofit2.http.Query

public interface RetrofitInterface{

    @GET("/user/login")
    fun get_userLogin(@Query("id") id: String, @Query("password") password: String): Call
}