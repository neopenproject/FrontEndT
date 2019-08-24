package com.hackathon.co.kr.neopenproject.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkUtil {
    lateinit var retrofit: Retrofit
    var service: RetrofitInterface? = null
    var baseURL = "http://52.79.87.95:3001"

    fun getInstance(): RetrofitInterface {
        if (service == null) {

            retrofit = Retrofit.Builder()

                    .baseUrl(baseURL)

                    .client(requestHeader)

                    .addConverterFactory(GsonConverterFactory.create())     // Json Parser 추가

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