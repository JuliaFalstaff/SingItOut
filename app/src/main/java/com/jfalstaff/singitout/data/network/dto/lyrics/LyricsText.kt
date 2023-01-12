package com.jfalstaff.singitout.data.network.dto.lyrics

import com.squareup.moshi.Json

data class LyricsText(
    @Json(name = "body")
    val body: Body
)
