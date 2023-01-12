package com.jfalstaff.singitout.data.network.dto.albums

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize


@Parcelize
data class Albums(
    @Json(name = "_type")
    val type: String? = "",
    @Json(name = "api_path")
    val apiPath: String? = "",
    @Json(name = "cover_art_thumbnail_url")
    val coverArtThumbnailUrl: String? = "",
    @Json(name = "cover_art_url")
    val coverArtUrl: String? = "",
    @Json(name = "full_title")
    val fullTitle: String? = "",
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "name")
    val name: String? = "",
    @Json(name = "name_with_artist")
    val nameWithArtist: String? = "",
    @Json(name = "release_date_components")
    val releaseDateComponents: ReleaseDateComponents? = ReleaseDateComponents(),
    @Json(name = "url")
    val url: String? = "",
    @Json(name = "artist")
    val artist: ArtistAlbum? = ArtistAlbum()
) : Parcelable