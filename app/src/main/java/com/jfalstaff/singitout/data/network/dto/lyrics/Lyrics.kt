package com.jfalstaff.singitout.data.network.dto.lyrics

import com.google.gson.annotations.Expose
import com.squareup.moshi.Json


data class Lyrics(
    @Json(name = "_type")
    @Expose
    var type: String? = "",

    @Json(name = "api_path")
    @Expose
    var apiPath: String? = "",

    @Json(name = "lyrics")
    @Expose
    var lyrics: LyricsText? = null,

    @Json(name = "path")
    @Expose
    var path: String? = "",

    @Json(name = "song_id")
    @Expose
    var songId: Int? = 0,
//
//    @Json(name="tracking_data")
//    @Expose
//    var trackingData: TrackingData? = null,
)

