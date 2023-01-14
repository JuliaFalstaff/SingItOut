package com.jfalstaff.singitout.domain.entities.artistEntity

import com.squareup.moshi.Json

data class Response(
    @Json(name = "artist")
    val artist: Artist
)
