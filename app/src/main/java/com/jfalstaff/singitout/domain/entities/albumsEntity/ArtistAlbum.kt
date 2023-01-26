package com.jfalstaff.singitout.domain.entities.albumsEntity

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArtistAlbum(
    @Json(name = "header_image_url")
    var headerImageUrl: String? = "",
    @Json(name = "id")
    var id: Int = 0,
    @Json(name = "image_url")
    var imageUrl: String? = "",
    @Json(name = "name")
    var name: String? = "",
    @Json(name = "url")
    var url: String? = "",
) : Parcelable

