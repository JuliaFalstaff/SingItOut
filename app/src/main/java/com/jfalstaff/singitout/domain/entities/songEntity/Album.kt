package com.jfalstaff.singitout.domain.entities.songEntity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Album(
    val apiPath: String? = "",
    val coverArtUrl: String? = "",
    val fullTitle: String? = "",
    val id: Int = 0,
    val name: String? = "",
    val url: String? = ""
) : Parcelable
