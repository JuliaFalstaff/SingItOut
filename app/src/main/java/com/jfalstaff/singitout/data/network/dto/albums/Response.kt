package com.jfalstaff.singitout.data.network.dto.albums

import com.squareup.moshi.Json


data class Response(
    @Json(name = "albums")
    val albums: List<Albums>? = listOf(
        Albums(id = 1, name = "dhsjdhuwuw 1"),
        Albums(id = 2, name = "skjdkdjs 2")
    ),
    @Json(name = "next_page")
    val nextPage: String? = ""
)