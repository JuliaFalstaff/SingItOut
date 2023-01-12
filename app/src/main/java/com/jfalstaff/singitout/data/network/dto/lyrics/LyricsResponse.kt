package com.jfalstaff.singitout.data.network.dto.lyrics

import com.squareup.moshi.Json

data class LyricsResponse(
    @Json(name = "lyrics")
    val lyrics: Lyrics
)
