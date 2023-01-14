package com.jfalstaff.singitout.data.network.dto.albums

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArtistAlbumDto(
    @Json(name = "_type")
    var type: String? = "",

    @Json(name = "api_path")
    var apiPath: String? = "",

    @Json(name = "header_image_url")
    var headerImageUrl: String? = "",

    @Json(name = "id")
    var id: Int = 0,

    @Json(name = "image_url")
    var imageUrl: String? = "",

    @Json(name = "index_character")
    var indexCharacter: String? = "",

    @Json(name = "is_meme_verified")
    var isMemeVerified: Boolean = false,

    @Json(name = "is_verified")
    var isVerified: Boolean = false,

    @Json(name = "name")
    var name: String? = "",

    @Json(name = "slug")
    var slug: String? = "",

    @Json(name = "url")
    var url: String? = "",
) : Parcelable

