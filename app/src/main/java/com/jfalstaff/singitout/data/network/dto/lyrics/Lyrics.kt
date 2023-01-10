package com.jfalstaff.singitout.data.network.dto.lyrics

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class Lyrics (
    @SerializedName("_type")
    @Expose
    var type: String? = "",

    @SerializedName("api_path")
    @Expose
    var apiPath: String? = "",

    @SerializedName("lyrics")
    @Expose
    var lyrics: LyricsText? = null,

    @SerializedName("path")
    @Expose
    var path: String? = "",

    @SerializedName("song_id")
    @Expose
    var songId: Int? = 0,
//
//    @SerializedName("tracking_data")
//    @Expose
//    var trackingData: TrackingData? = null,
)

