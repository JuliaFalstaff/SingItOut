package com.jfalstaff.singitout.data.network.dto.tracks

import com.squareup.moshi.Json

data class Response(
    @Json(name = "tracks")
    val tracks: List<Track>? = null
)

