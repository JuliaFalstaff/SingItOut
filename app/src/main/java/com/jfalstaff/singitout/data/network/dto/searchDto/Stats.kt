package com.jfalstaff.singitout.data.network.dto.searchDto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Stats(
    @SerializedName("unreviewed_annotations")
    val unreviewedAnnotations: Int,
    @SerializedName("hot")
    val hot: Boolean,
    @SerializedName("pageviews")
    val pageViews: Int
): Parcelable
