package com.jfalstaff.singitout.data.network.dto.song

import com.squareup.moshi.Json

data class Response(
    @Json(name = "song")
    val song: Song
)
