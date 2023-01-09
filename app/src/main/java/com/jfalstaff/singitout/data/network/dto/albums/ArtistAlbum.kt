package com.jfalstaff.singitout.data.network.dto.albums

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArtistAlbum (
    @SerializedName("_type")
    var type: String? = "",

    @SerializedName("api_path")
    var apiPath: String? = "",

    @SerializedName("header_image_url")
    var headerImageUrl: String? = "",

    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("image_url")
    var imageUrl: String? = "",

    @SerializedName("index_character")
    var indexCharacter: String? = "",

    @SerializedName("is_meme_verified")
    var isMemeVerified: Boolean = false,

    @SerializedName("is_verified")
    var isVerified: Boolean = false,

    @SerializedName("name")
    var name: String? = "",

    @SerializedName("slug")
    var slug: String? = "",

    @SerializedName("url")
    var url: String? = "",
): Parcelable

