package com.jfalstaff.singitout.data.network

import com.jfalstaff.singitout.data.network.dto.lyrics.LyricsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRapidLyricsService {

    @GET("song/lyrics/")
    suspend fun getSongsLyric(
        @Query("id") id: Int,
        @Query("text_format") text_format: String = PLAIN_TEXT_FORMAT_RESPONSE
    ): LyricsResponse

    companion object {
        private const val PLAIN_TEXT_FORMAT_RESPONSE = "plain"
    }
}