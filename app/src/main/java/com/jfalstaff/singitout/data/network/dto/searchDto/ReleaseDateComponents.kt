package com.jfalstaff.singitout.data.network.dto.searchDto

import com.google.gson.annotations.SerializedName

data class ReleaseDateComponents(
    @SerializedName("year")
    val year: Int,
    @SerializedName("month")
    val month: Int,
    @SerializedName("day")
    val day: Int
)
