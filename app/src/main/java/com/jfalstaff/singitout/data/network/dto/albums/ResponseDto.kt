package com.jfalstaff.singitout.data.network.dto.albums

import com.squareup.moshi.Json


data class ResponseDto(
    @Json(name = "albums")
    val albums: List<AlbumsDto>? = null,
    @Json(name = "next_page")
    val nextPage: String? = ""
)