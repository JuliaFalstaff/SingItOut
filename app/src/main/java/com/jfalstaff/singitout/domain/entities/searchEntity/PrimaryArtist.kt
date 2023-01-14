package com.jfalstaff.singitout.domain.entities.searchEntity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class PrimaryArtist(
    val apiPath: String? ="",
    val headerImageUrl: String? ="",
    val id: Int,
    val imageUrl: String? ="",
    val name: String? ="",
    val url: String? =""
): Parcelable
