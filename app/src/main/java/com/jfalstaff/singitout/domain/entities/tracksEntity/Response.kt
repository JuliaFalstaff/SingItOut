package com.jfalstaff.singitout.domain.entities.tracksEntity

import com.squareup.moshi.Json

data class Response(
    @Json(name = "tracks")
    val tracks: List<Track>? = null
)

