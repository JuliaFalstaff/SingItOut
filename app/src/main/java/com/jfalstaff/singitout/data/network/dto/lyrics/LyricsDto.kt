package com.jfalstaff.singitout.data.network.dto.lyrics

import com.google.gson.annotations.Expose
import com.squareup.moshi.Json


data class LyricsDto(
    @Json(name = "_type")
    @Expose
    var type: String? = "",

    @Json(name = "api_path")
    @Expose
    var apiPath: String? = "",

    @Json(name = "lyrics")
    @Expose
    var lyrics: LyricsTextDto? = null,

    @Json(name = "path")
    @Expose
    var path: String? = "",

    @Json(name = "song_id")
    @Expose
    var songId: Int? = 0,
)

