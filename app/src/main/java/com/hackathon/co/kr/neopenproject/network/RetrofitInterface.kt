package com.hackathon.co.kr.neopenproject.network

import com.hackathon.co.kr.neopenproject.vo.ResponseVO
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitInterface{

    @GET("/")
    fun get_userLogin(): Call<ResponseVO>

    @FormUrlEncoded
    @POST("/api/v1/account/teacher")
    fun post_userSinup(@Field("email") email: String, @Field("pwd") pwd: String): Call<ResponseVO>

    @FormUrlEncoded
    @POST("/api/v1/account/teacher/login")
    fun post_userLogin(@Field("email") email: String, @Field("pwd") pwd: String): Call<ResponseVO>
}