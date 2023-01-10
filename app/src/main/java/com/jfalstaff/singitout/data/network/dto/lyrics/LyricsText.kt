package com.jfalstaff.singitout.data.network.dto.lyrics

import com.google.gson.annotations.SerializedName

data class LyricsText(
    @SerializedName("body")
    val body: Body

)
