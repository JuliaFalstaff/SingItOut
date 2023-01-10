package com.jfalstaff.singitout.data.network

import com.jfalstaff.singitout.BuildConfig
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val BASE_URL = "https://api.genius.com/"
    private const val BASE_MUSIC_URL = "https://genius.com/api/"
    private const val BASE_RAPID_API_LYRICS_URL = "https://genius-song-lyrics1.p.rapidapi.com/"
    private const val tokenGenius = BuildConfig.TOKEN_GENIUS
    private const val tokenRapidGenius = BuildConfig.TOKEN_RAPID_GENIUS

        private val requestInterceptor = Interceptor { chain ->
        val requestWithHeader = chain.request()
            .newBuilder()
            .header("Authorization", "Bearer $tokenGenius")
            .build()
        chain.proceed(requestWithHeader)
    }

    private val requestRapidInterceptor = Interceptor { chain ->
        val requestWithHeaders = chain.request()
            .newBuilder()
            .header("X-RapidAPI-Key", tokenRapidGenius)
            .header("X-RapidAPI-Host", "genius-song-lyrics1.p.rapidapi.com")
            .build()
        chain.proceed(requestWithHeaders)
    }

    private val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(requestInterceptor)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private val okHttpRapidClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(requestRapidInterceptor)
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

    private val retrofitLyrics = Retrofit.Builder()
        .client(okHttpRapidClient)
        .baseUrl(BASE_RAPID_API_LYRICS_URL)
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
    val apiRapidLyricsService: ApiRapidLyricsService = retrofitLyrics.create(ApiRapidLyricsService::class.java)
}