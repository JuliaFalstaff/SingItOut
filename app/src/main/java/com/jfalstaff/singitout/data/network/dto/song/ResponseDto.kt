package com.jfalstaff.singitout.data.network.dto.song

import com.squareup.moshi.Json

data class ResponseDto(
    @Json(name = "song")
    val song: SongDto
)
