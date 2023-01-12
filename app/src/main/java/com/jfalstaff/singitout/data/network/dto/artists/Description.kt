package com.jfalstaff.singitout.data.network.dto.artists

import com.squareup.moshi.Json

data class Description(
    @Json(name = "plain")
    val plain: String? = ""
)
