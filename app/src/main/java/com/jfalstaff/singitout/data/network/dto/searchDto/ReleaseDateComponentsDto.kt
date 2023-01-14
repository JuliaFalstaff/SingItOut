package com.jfalstaff.singitout.data.network.dto.searchDto

import com.squareup.moshi.Json

data class ReleaseDateComponentsDto(
    @Json(name = "year")
    val year: Int? = 0,
    @Json(name = "month")
    val month: Int? = 0,
    @Json(name = "day")
    val day: Int? = 0
)
