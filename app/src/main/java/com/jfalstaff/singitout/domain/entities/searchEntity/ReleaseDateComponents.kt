package com.jfalstaff.singitout.domain.entities.searchEntity

import com.squareup.moshi.Json

data class ReleaseDateComponents(
    @Json(name = "year")
    val year: Int? = 0,
    @Json(name = "month")
    val month: Int? = 0,
    @Json(name = "day")
    val day: Int? = 0
)
