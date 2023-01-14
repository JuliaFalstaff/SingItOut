package com.jfalstaff.singitout.domain.entities.searchEntity

import com.squareup.moshi.Json

data class Hit(
    @Json(name = "type")
    val type: String,
    @Json(name = "result")
    val result: Result
)
