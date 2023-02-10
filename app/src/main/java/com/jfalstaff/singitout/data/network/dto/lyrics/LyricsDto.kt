package com.jfalstaff.singitout.data.network.dto.lyrics

import com.squareup.moshi.Json


data class LyricsDto(
    @Json(name = "_type")
    var type: String? = "",

    @Json(name = "api_path")
    var apiPath: String? = "",

    @Json(name = "lyrics")
    var lyrics: LyricsTextDto? = null,

    @Json(name = "path")
    var path: String? = "",

    @Json(name = "song_id")
    var songId: Int? = 0,
)

