package com.jfalstaff.singitout.data.network.dto.searchDto

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Stats(
    @Json(name = "unreviewed_annotations")
    val unreviewedAnnotations: Int? = 0,
    @Json(name = "hot")
    val hot: Boolean = false,
    @Json(name = "pageviews")
    val pageViews: Int? = 0
) : Parcelable
