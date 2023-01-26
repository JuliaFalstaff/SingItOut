package com.jfalstaff.singitout.data.network.dto.searchDto

import com.squareup.moshi.Json

data class ResponseDto(
    @Json(name = "hits")
    val hits: List<HitDto>? = null
)
