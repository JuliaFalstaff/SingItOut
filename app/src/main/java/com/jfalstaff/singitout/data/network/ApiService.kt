package com.jfalstaff.singitout.data.network

import com.jfalstaff.singitout.data.network.dto.artists.ResponseArtist
import com.jfalstaff.singitout.data.network.dto.searchDto.ResponseServer
import com.jfalstaff.singitout.data.network.dto.tracks.ResponseAlbumTracks
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("search")
    suspend fun searchResult(
        @Query("q") searchExpression: String,
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): ResponseServer

    @GET("/artists/{id}")
    suspend fun getArtistInfo(
        @Path("id") id: Int,
        @Query("text_format") text_format: String = PLAIN_TEXT_FORMAT_RESPONSE
    ): ResponseArtist


    @GET("/albums/{id}/tracks")
    suspend fun getAlbumTracks(
        @Path("id") id: Int
    ): ResponseAlbumTracks

    companion object {
        private const val PLAIN_TEXT_FORMAT_RESPONSE = "plain"
    }
}