package com.jfalstaff.singitout.data.network

import com.jfalstaff.singitout.BuildConfig
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val BASE_URL = "https://api.genius.com/"
    private const val tokenGenius = BuildConfig.TOKEN_GENIUS

    private val requestInterceptor = Interceptor { chain ->
        val requestWithHeader = chain.request()
            .newBuilder()
            .header("Authorization", "Bearer $tokenGenius")
            .build()
        chain.proceed(requestWithHeader)
    }

    private val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(requestInterceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)

}