package com.jfalstaff.singitout.domain.entities.albumsEntity

import com.squareup.moshi.Json


data class Response(
    @Json(name = "albums")
    val albums: List<Albums>? = null,
    @Json(name = "next_page")
    val nextPage: String? = ""
)