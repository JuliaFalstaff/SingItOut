package com.jfalstaff.singitout.data.network.dto.searchDto

import com.squareup.moshi.Json

data class Response(
    @Json(name = "hits")
    val hits: List<Hit>? = null
)
