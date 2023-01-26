package com.jfalstaff.singitout.domain.entities.searchEntity



data class Result(
    val apiPath: String? = "",
    val artistNames: String? = "",
    val fullTitle: String? = "",
    val headerImageThumbnailUrl: String? = "",
    val headerImageUrl: String? = "",
    val id: Int? = 0,
    val language: String? = "",
    val releaseDateComponents: ReleaseDateComponents? = null,
    val releaseDateForDisplay: String? = "",
    val songArtImageThumbnailUrl: String? = "",
    val songArtImageUrl: String? = "",
    val title: String? = "",
    val titleWithFeatured: String? = "",
    val url: String? = "",
    val primaryArtist: PrimaryArtist,
)
