package com.jfalstaff.singitout.data.network

import com.jfalstaff.singitout.BuildConfig
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val BASE_URL = "https://api.genius.com/"
    private const val BASE_MUSIC_URL = "https://genius.com/api/"
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
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitMusic = Retrofit.Builder()
        .client(createOkHttpClient())
        .baseUrl(BASE_MUSIC_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun createOkHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(
            HttpLoggingInterceptor().setLevel(
                HttpLoggingInterceptor.Level.BODY
            )
        )
        return httpClient.build()
    }

    val apiService: ApiService = retrofit.create(ApiService::class.java)
    val apiMusicService: ApiMusicService = retrofitMusic.create(ApiMusicService::class.java)
}