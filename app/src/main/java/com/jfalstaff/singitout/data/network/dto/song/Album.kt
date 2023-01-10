package com.jfalstaff.singitout.data.network.dto.song

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Album(
    @SerializedName("api_path")
    val apiPath: String? = "",
    @SerializedName("cover_art_url")
    val coverArtUrl: String? = "",
    @SerializedName("full_title")
    val fullTitle: String? = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("url")
    val url: String? = ""
): Parcelable
