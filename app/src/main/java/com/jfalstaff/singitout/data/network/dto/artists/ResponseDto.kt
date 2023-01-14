package com.jfalstaff.singitout.data.network.dto.artists

import com.squareup.moshi.Json

data class ResponseDto(
    @Json(name = "artist")
    val artist: ArtistDto
)
