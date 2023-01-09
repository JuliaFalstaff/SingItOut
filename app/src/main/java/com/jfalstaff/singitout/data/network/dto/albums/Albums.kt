package com.jfalstaff.singitout.data.network.dto.albums

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Albums(
    @SerializedName("_type")
    val type: String? = "",
    @SerializedName("api_path")
    val apiPath: String? = "",
    @SerializedName("cover_art_thumbnail_url")
    val coverArtThumbnailUrl: String? = "",
    @SerializedName("cover_art_url")
    val coverArtUrl: String? = "",
    @SerializedName("full_title")
    val fullTitle: String? = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("name_with_artist")
    val nameWithArtist: String? = "",
    @SerializedName("release_date_components")
    val releaseDateComponents: ReleaseDateComponents? = ReleaseDateComponents(),
    @SerializedName("url")
    val url: String? = "",
    @SerializedName("artist")
    val artist: ArtistAlbum? = ArtistAlbum()
): Parcelable