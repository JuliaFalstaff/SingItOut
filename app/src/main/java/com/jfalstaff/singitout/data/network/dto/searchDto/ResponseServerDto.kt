package com.jfalstaff.singitout.data.network.dto.searchDto

import com.squareup.moshi.Json


data class ResponseServerDto(
    @Json(name = "meta")
    val meta: MetaDto,
    @Json(name = "response")
    val response: ResponseDto
)
