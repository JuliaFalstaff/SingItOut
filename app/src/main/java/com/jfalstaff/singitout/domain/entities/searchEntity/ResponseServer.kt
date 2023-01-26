package com.jfalstaff.singitout.domain.entities.searchEntity

import com.squareup.moshi.Json


data class ResponseServer(
    @Json(name = "meta")
    val meta: Meta,
    @Json(name = "response")
    val response: Response
)
