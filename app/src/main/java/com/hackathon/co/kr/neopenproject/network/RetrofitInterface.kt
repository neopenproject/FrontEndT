package com.hackathon.co.kr.neopenproject.network

import com.hackathon.co.kr.neopenproject.vo.ProblemVO
import com.hackathon.co.kr.neopenproject.vo.ResponseVO
import retrofit2.Call
import retrofit2.http.*

interface RetrofitInterface {

    @GET("/")
    fun get_userLogin(): Call<ResponseVO>

    @FormUrlEncoded
    @POST("/api/v1/account/teacher")
    fun post_userSinup(@Field("email") email: String, @Field("pwd") pwd: String): Call<ResponseVO>

    @FormUrlEncoded
    @POST("/api/v1/account/teacher/login")
    fun post_userLogin(@Field("email") email: String, @Field("pwd") pwd: String): Call<ResponseVO>

    @GET("/api/v1/problem/post")
    fun getAnswerPost(): Call<ProblemVO>
}