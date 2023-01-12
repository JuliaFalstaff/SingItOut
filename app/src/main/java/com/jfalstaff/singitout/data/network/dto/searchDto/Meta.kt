package com.jfalstaff.singitout.data.network.dto.searchDto

import com.squareup.moshi.Json

data class Meta(
    @Json(name = "status")
    val status: Int
)
