package com.jfalstaff.singitout.domain.entities.albumsEntity

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReleaseDateComponents(
    @Json(name = "year")
    val year: Int? = 0,
    @Json(name = "month")
    val month: Int? = 0,
    @Json(name = "day")
    val day: Int? = 0
) : Parcelable