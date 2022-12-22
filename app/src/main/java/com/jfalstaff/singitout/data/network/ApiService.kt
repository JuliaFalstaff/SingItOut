package com.jfalstaff.singitout.data.network

import com.jfalstaff.singitout.data.network.dto.searchDto.ResponseServer
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search")
    suspend fun searchResult(
        @Query("q") searchExpression: String,
        @Query("per_page") per_page: Int = 15
    ): ResponseServer
}