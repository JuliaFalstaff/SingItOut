package com.jfalstaff.singitout.data.network.dto.searchDto

import com.google.gson.annotations.SerializedName

data class Stats(
    @SerializedName("unreviewed_annotations")
    val unreviewedAnnotations: Int,
    @SerializedName("hot")
    val hot: Boolean,
    @SerializedName("pageviews")
    val pageViews: Int
)
