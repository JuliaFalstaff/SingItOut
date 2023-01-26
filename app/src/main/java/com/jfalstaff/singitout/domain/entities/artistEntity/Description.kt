package com.jfalstaff.singitout.domain.entities.artistEntity

import com.squareup.moshi.Json

data class Description(
    @Json(name = "plain")
    val plain: String? = ""
)
