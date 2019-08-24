package com.hackathon.co.kr.neopenproject.network

import com.hackathon.co.kr.neopenproject.vo.ResponseVO
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitInterface{
    @GET("/api/v1")
    fun get_userLogin(): Call<ResponseVO>

    @POST("/account/teacher")
    fun post_userSinup(@Field("email") email: String, @Field("pwd") pwd: String): Call<ResponseVO>


    @POST("/account/teacher/login")
    fun post_userLogin(@Field("email") email: String, @Field("pwd") pwd: String): Call<ResponseVO>
}