package com.jfalstaff.singitout.data.network.dto.tracks

import android.os.Parcelable
import com.jfalstaff.singitout.data.network.dto.searchDto.PrimaryArtistDto
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class SongDto (
    @Json(name="annotation_count")
    val annotationCount: Int? = 0,

    @Json(name="api_path")
    val apiPath: String? = "",

    @Json(name="artist_names")
    val artistNames: String? = "",

    @Json(name="full_title")
    val fullTitle: String? = "",

    @Json(name="header_image_thumbnail_url")
    val headerImageThumbnailUrl: String? = "",

    @Json(name="header_image_url")
    val headerImageUrl: String? = "",

    @Json(name="id")
    val id: Int? = 0,

    @Json(name="language")
    val language: String? = "",

    @Json(name="lyrics_owner_id")
    val lyricsOwnerId: Int? = 0,

    @Json(name="lyrics_state")
    val lyricsState: String? = "",

    @Json(name="path")
    val path: String? = "",

    @Json(name="relationships_index_url")
    val relationshipsIndexUrl: String? = "",
//
    @Json(name="release_date_for_display")
    val releaseDateForDisplay: String? = "",

    @Json(name="song_art_image_thumbnail_url")
    val songArtImageThumbnailUrl: String? = "",

    @Json(name="song_art_image_url")
    val songArtImageUrl: String? = "",

    @Json(name="title")
    val title: String? = "",

    @Json(name="title_with_featured")
    val titleWithFeatured: String? = "",

    @Json(name="url")
    val url: String? = "",

    @Json(name="primary_artist")
    val primaryArtist: PrimaryArtistDto? = null
): Parcelable

