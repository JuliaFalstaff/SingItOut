package com.jfalstaff.singitout.domain.entities.searchEntity

import com.squareup.moshi.Json

data class Response(
    @Json(name = "hits")
    val hits: List<Hit>? = null
)
