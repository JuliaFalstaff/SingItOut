package com.jfalstaff.singitout.domain.entities.albumsEntity


import com.jfalstaff.singitout.domain.entities.searchEntity.Meta
import com.squareup.moshi.Json

data class ResponseAlbums(
    @Json(name = "meta")
    val meta: Meta,
    @Json(name = "response")
    val response: Response?
)
