package com.hackathon.co.kr.neopenproject.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder
import com.google.gson.Gson



object RetrofitServer {
    lateinit var retrofit: Retrofit
    var service: RetrofitInterface? = null
    var baseURL = "http://ec2-15-164-171-69.ap-northeast-2.compute.amazonaws.com/"

    fun getInstance(): RetrofitInterface {
        if (service == null) {

            val gson = GsonBuilder()
                    .setLenient()
                    .create()

            retrofit = Retrofit.Builder()
                    .baseUrl(baseURL)
                    .client(requestHeader)
                    .addConverterFactory(GsonConverterFactory.create(gson))     // Json Parser 추가
                    .build()

            service = retrofit.create(RetrofitInterface::class.java)   // 인터페이스 연결

        }

        return service!!
    }

    private val requestHeader: OkHttpClient
        get() {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            return OkHttpClient.Builder()
                    .addInterceptor(interceptor).build()

        }

}