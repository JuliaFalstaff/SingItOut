package com.jfalstaff.singitout.domain.entities.searchEntity

import com.squareup.moshi.Json

data class Meta(
    @Json(name = "status")
    val status: Int
)
