package com.jfalstaff.singitout.data.network.dto.searchDto

import com.squareup.moshi.Json

data class Result(
    @Json(name = "annotation_count")
    val annotationCount: Int?= 0,
    @Json(name = "api_path")
    val apiPath: String?="",
    @Json(name = "artist_names")
    val artistNames: String?="",
    @Json(name = "full_title")
    val fullTitle: String?="",
    @Json(name = "header_image_thumbnail_url")
    val headerImageThumbnailUrl: String?="",
    @Json(name = "header_image_url")
    val headerImageUrl: String?="",
    @Json(name = "id")
    val id: Int?= 0,
    @Json(name = "language")
    val language: String?="",
    @Json(name = "lyrics_owner_id")
    val lyricsOwnerId: Int?,
    @Json(name = "lyrics_state")
    val lyricsState: String?="",
    @Json(name = "path")
    val path: String?="",
    @Json(name = "pyongs_count")
    val pyongsCount: Int? = 0,
    @Json(name = "relationships_index_url")
    val relationshipsIndexUrl: String?="",
    @Json(name = "release_date_components")
    val releaseDateComponents: ReleaseDateComponents? = null,
    @Json(name = "release_date_for_display")
    val releaseDateForDisplay: String?="",
    @Json(name = "release_date_with_abbreviated_month_for_display")
    val releaseDateWithAbbreviatedMonthForDisplay: String?="",
    @Json(name = "song_art_image_thumbnail_url")
    val songArtImageThumbnailUrl: String?="",
    @Json(name = "song_art_image_url")
    val songArtImageUrl: String?="",
    @Json(name = "stats")
    val stats: Stats,
    @Json(name = "title")
    val title: String?="",
    @Json(name = "title_with_featured")
    val titleWithFeatured: String?="",
    @Json(name = "url")
    val url: String?="",
    @Json(name = "featured_artists")
    val featuredArtists: List<FeaturedArtist>? = null,
    @Json(name = "primary_artist")
    val primaryArtist: PrimaryArtist,
)
