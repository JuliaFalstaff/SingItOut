package com.jfalstaff.singitout.data.network.dto.tracks

import com.squareup.moshi.Json

data class ResponseDto(
    @Json(name = "tracks")
    val tracks: List<TrackDto>? = null
)

