package com.jfalstaff.singitout.data.network.dto.song

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Album(
    @Json(name = "api_path")
    val apiPath: String? = "",
    @Json(name = "cover_art_url")
    val coverArtUrl: String? = "",
    @Json(name = "full_title")
    val fullTitle: String? = "",
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "name")
    val name: String? = "",
    @Json(name = "url")
    val url: String? = ""
) : Parcelable
