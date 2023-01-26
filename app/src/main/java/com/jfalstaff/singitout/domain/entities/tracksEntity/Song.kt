package com.jfalstaff.singitout.domain.entities.tracksEntity

import android.os.Parcelable
import com.jfalstaff.singitout.data.network.dto.searchDto.PrimaryArtistDto
import kotlinx.parcelize.Parcelize

@Parcelize
data class Song(
    val apiPath: String? = "",
    val artistNames: String? = "",
    val fullTitle: String? = "",
    val headerImageThumbnailUrl: String? = "",
    val headerImageUrl: String? = "",
    val id: Int? = 0,
    val releaseDateForDisplay: String? = "",
    val songArtImageThumbnailUrl: String? = "",
    val songArtImageUrl: String? = "",
    val title: String? = "",
    val titleWithFeatured: String? = "",
    val url: String? = "",
    val primaryArtist: PrimaryArtistDto? = null
) : Parcelable

