package com.jfalstaff.singitout.data.network.dto.tracks

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Track (
    @SerializedName("number")
    val number: Int = 0,

    @SerializedName("song")
    val song: Song? = null
): Parcelable

