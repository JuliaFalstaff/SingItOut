package com.jfalstaff.singitout.data.network.dto.song

import com.jfalstaff.singitout.data.network.dto.searchDto.MetaDto
import com.squareup.moshi.Json

data class ResponseSongDto(
    @Json(name = "meta")
    val meta: MetaDto,
    @Json(name="response")
    val response: ResponseDto,
)
