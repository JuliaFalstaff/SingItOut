package com.jfalstaff.singitout.data.network.dto.tracks

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class TrackDto (
    @Json(name="number")
    val number: Int = 0,
    @Json(name="song")
    val song: SongDto? = null
): Parcelable

