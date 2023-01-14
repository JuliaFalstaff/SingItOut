package com.jfalstaff.singitout.data.network.dto.lyrics

import com.squareup.moshi.Json

data class LyricsTextDto(
    @Json(name = "body")
    val body: BodyDto
)
