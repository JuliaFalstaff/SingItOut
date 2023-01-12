package com.jfalstaff.singitout.data.network.dto.song

import com.jfalstaff.singitout.data.network.dto.searchDto.Meta
import com.squareup.moshi.Json

data class ResponseSong(
    @Json(name = "meta")
    val meta: Meta,
    @Json(name="response")
    val response: Response,
)
