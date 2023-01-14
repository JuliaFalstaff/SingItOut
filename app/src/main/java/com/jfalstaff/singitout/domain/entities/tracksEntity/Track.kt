package com.jfalstaff.singitout.domain.entities.tracksEntity

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Track (
    @Json(name="number")
    val number: Int = 0,
    @Json(name="song")
    val song: Song? = null
): Parcelable

