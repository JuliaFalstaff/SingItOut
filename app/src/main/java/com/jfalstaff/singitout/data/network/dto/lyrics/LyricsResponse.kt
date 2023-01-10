package com.jfalstaff.singitout.data.network.dto.lyrics

import com.google.gson.annotations.SerializedName

data class LyricsResponse(
    @SerializedName("lyrics")
    val lyrics: Lyrics
)
