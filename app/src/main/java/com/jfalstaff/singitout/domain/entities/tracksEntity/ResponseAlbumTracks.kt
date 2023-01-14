package com.jfalstaff.singitout.domain.entities.tracksEntity

import com.jfalstaff.singitout.domain.entities.searchEntity.Meta
import com.squareup.moshi.Json

data class ResponseAlbumTracks(
    @Json(name = "meta")
    val meta: Meta,
    @Json(name="response")
    val response: Response,
)
