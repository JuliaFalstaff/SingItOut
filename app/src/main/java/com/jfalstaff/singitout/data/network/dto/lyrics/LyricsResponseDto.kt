package com.jfalstaff.singitout.data.network.dto.lyrics

import com.squareup.moshi.Json

data class LyricsResponseDto(
    @Json(name = "lyrics")
    val lyrics: LyricsDto
)
