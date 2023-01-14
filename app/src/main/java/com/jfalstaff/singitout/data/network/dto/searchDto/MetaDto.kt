package com.jfalstaff.singitout.data.network.dto.searchDto

import com.squareup.moshi.Json

data class MetaDto(
    @Json(name = "status")
    val status: Int
)
