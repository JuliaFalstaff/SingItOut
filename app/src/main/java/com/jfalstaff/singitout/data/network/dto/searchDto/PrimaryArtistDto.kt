package com.jfalstaff.singitout.data.network.dto.searchDto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class PrimaryArtistDto(
    @Json(name="api_path")
    val apiPath: String? ="",
    @Json(name="header_image_url")
    val headerImageUrl: String? ="",
    @Json(name="id")
    val id: Int,
    @Json(name="image_url")
    val imageUrl: String? ="",
    @Json(name="is_meme_verified")
    val isMemeVerified: Boolean = false,
    @Json(name="is_verified")
    val isVerified: Boolean = false,
    @Json(name="name")
    val name: String? ="",
    @Json(name="url")
    val url: String? =""
): Parcelable
