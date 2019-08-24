package com.hackathon.co.kr.neopenproject.network

import com.hackathon.co.kr.neopenproject.vo.DataVO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

public interface RetrofitInterface{
    @GET("/api/v1")
    fun get_userLogin(): Call<DataVO>
}