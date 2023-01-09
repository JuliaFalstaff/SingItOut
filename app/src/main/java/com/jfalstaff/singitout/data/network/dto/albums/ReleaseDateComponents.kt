package com.jfalstaff.singitout.data.network.dto.albums

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReleaseDateComponents(
    @SerializedName("year")
    val year: Int? = 0,
    @SerializedName("month")
    val month: Int? = 0,
    @SerializedName("day")
    val day: Int? = 0
): Parcelable