package com.jfalstaff.singitout.data.network.dto.tracks

import com.google.gson.annotations.SerializedName

data class Response (
    @SerializedName("tracks")
    val tracks: List<Track>? = null
)

