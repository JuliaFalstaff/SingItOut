package com.jfalstaff.singitout.data.network.dto.lyrics

import com.squareup.moshi.Json

data class Body(
    @Json(name = "plain")
    val plain: String? =""
)
