package com.jfalstaff.singitout.domain.entities.albumsEntity

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize


@Parcelize
data class Albums(
    val apiPath: String? = "",
    val coverArtThumbnailUrl: String? = "",
    val coverArtUrl: String? = "",
    val fullTitle: String? = "",
    val id: Int = 0,
    val name: String? = "",
    val releaseDateComponents: ReleaseDateComponents? = ReleaseDateComponents(),
    val url: String? = "",
    val artist: ArtistAlbum? = ArtistAlbum()
) : Parcelable