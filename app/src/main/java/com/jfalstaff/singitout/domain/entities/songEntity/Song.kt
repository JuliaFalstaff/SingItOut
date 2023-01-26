package com.jfalstaff.singitout.domain.entities.songEntity

import android.os.Parcelable
import com.jfalstaff.singitout.domain.entities.searchEntity.PrimaryArtist
import kotlinx.parcelize.Parcelize

@Parcelize
data class Song(
    var appleMusicId: String? = "",
    var appleMusicPlayerUrl: String? = "",
    var artistNames: String? = "",
    var fullTitle: String? = "",
    var headerImageThumbnailUrl: String? = "",
    var headerImageUrl: String? = "",
    var id: Int? = 0,
    var path: String? = "",
    var releaseDate: String? = "",
    var releaseDateForDisplay: String? = "",
    var releaseDateWithAbbreviatedMonthForDisplay: String? = "",
    var songArtImageThumbnailUrl: String? = "",
    var songArtImageUrl: String? = "",
    var title: String? = "",
    var titleWithFeatured: String? = "",
    var url: String? = "",
    var album: Album? = null,
    var primaryArtist: PrimaryArtist? = null
) : Parcelable

