package com.jfalstaff.singitout.data.network.api

import com.jfalstaff.singitout.data.network.dto.artists.ResponseArtistDto
import com.jfalstaff.singitout.data.network.dto.searchDto.ResponseServerDto
import com.jfalstaff.singitout.data.network.dto.song.ResponseSongDto
import com.jfalstaff.singitout.data.network.dto.tracks.ResponseAlbumTracksDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("search")
    suspend fun searchResult(
        @Query("q") searchExpression: String,
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): ResponseServerDto

    @GET("/artists/{id}")
    suspend fun getArtistInfo(
        @Path("id") id: Int,
        @Query("text_format") text_format: String = PLAIN_TEXT_FORMAT_RESPONSE
    ): ResponseArtistDto

    @GET("/albums/{id}/tracks")
    suspend fun getAlbumTracks(
        @Path("id") id: Int
    ): ResponseAlbumTracksDto

    @GET("/songs/{id}")
    suspend fun getSongInfo(
        @Path("id") id: Int
    ): ResponseSongDto

    companion object {
        private const val PLAIN_TEXT_FORMAT_RESPONSE = "plain"
    }
}