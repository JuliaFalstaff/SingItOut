package com.jfalstaff.singitout.domain.entities.artistEntity

import com.jfalstaff.singitout.data.network.dto.searchDto.MetaDto
import com.squareup.moshi.Json

data class ResponseArtist(
    @Json(name = "meta")
    val meta: MetaDto,
    @Json(name="response")
    val response: Response,
)
