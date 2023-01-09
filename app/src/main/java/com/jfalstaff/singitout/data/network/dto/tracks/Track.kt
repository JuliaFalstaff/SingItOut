package com.jfalstaff.singitout.data.network.dto.tracks

import com.google.gson.annotations.SerializedName


data class Track (
    @SerializedName("number")
    val number: Int = 0,

    @SerializedName("song")
    val song: Song? = null
)

