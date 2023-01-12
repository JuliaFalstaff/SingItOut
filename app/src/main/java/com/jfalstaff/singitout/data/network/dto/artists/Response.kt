package com.jfalstaff.singitout.data.network.dto.artists

import com.squareup.moshi.Json

data class Response(
    @Json(name = "artist")
    val artist: Artist
)
