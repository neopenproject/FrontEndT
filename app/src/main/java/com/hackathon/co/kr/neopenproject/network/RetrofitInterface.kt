package com.hackathon.co.kr.neopenproject.network

import com.hackathon.co.kr.neopenproject.vo.AnswerVO
import com.hackathon.co.kr.neopenproject.vo.ResponseVO
import retrofit2.Call
import retrofit2.http.*

interface RetrofitInterface{

    @GET("/")
    fun get_userLogin(): Call<ResponseVO>

    @GET("/api/v1/answer/post")
    fun get_answer(@Query("problem_post") id:Int): Call<AnswerVO>


    @GET("/api/v1/answer/{id}")
    fun get_userAnswer(@Path("id") id:Int, @Query("user_type") type:String): Call<AnswerVO>


    @FormUrlEncoded
    @POST("/api/v1/account/teacher")
    fun post_userSinup(@Field("email") email: String, @Field("pwd") pwd: String): Call<ResponseVO>

    @FormUrlEncoded
    @POST("/api/v1/account/teacher/login")
    fun post_userLogin(@Field("email") email: String, @Field("pwd") pwd: String): Call<ResponseVO>
}