package com.jfalstaff.singitout.data.network.dto.albums

import com.jfalstaff.singitout.data.network.dto.searchDto.MetaDto
import com.squareup.moshi.Json

data class ResponseAlbumsDto(
    @Json(name = "meta")
    val meta: MetaDto,
    @Json(name = "response")
    val response: ResponseDto?
)
