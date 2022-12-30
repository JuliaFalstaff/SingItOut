package com.jfalstaff.singitout.data.network.dto.albums

import com.google.gson.annotations.SerializedName


data class ReleaseDateComponents(
    @SerializedName("year")
    val year: Int? = 0,
    @SerializedName("month")
    val month: Int? = 0,
    @SerializedName("day")
    val day: Int? = 0

)