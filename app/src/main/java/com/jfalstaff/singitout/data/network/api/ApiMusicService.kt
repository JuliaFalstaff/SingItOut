package com.jfalstaff.singitout.data.network.api

import com.jfalstaff.singitout.data.network.dto.albums.ResponseAlbums
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiMusicService {
    @GET("artists/{id}/albums")
    suspend fun getArtistAlbums(
        @Path("id") artistId: Int
    ): ResponseAlbums
}