package com.jfalstaff.singitout.data.network.dto.song

import android.os.Parcelable
import com.jfalstaff.singitout.data.network.dto.searchDto.PrimaryArtistDto
import com.jfalstaff.singitout.data.network.dto.searchDto.StatsDto
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class SongDto(
    @Json(name = "annotation_count")
    var annotationCount: Int? = 0,

    @Json(name = "api_path")
    var apiPath: String? = "",

    @Json(name = "apple_music_id")
    var appleMusicId: String? = "",

    @Json(name = "apple_music_player_url")
    var appleMusicPlayerUrl: String? = "",

    @Json(name = "artist_names")
    var artistNames: String? = "",

    @Json(name = "embed_content")
    var embedContent: String? = "",

    @Json(name = "featured_video")
    var featuredVideo: Boolean? = false,

    @Json(name = "full_title")
    var fullTitle: String? = "",

    @Json(name = "header_image_thumbnail_url")
    var headerImageThumbnailUrl: String? = "",

    @Json(name = "header_image_url")
    var headerImageUrl: String? = "",

    @Json(name = "id")
    var id: Int? = 0,

    @Json(name = "language")
    var language: String? = "",

    @Json(name = "lyrics_owner_id")
    var lyricsOwnerId: Int? = 0,
    @Json(name = "lyrics_state")
    var lyricsState: String? = "",

    @Json(name = "path")
    var path: String? = "",

    @Json(name = "relationships_index_url")
    var relationshipsIndexUrl: String? = "",

    @Json(name = "release_date")
    var releaseDate: String? = "",

    @Json(name = "release_date_for_display")
    var releaseDateForDisplay: String? = "",

    @Json(name = "release_date_with_abbreviated_month_for_display")
    var releaseDateWithAbbreviatedMonthForDisplay: String? = "",

    @Json(name = "song_art_image_thumbnail_url")
    var songArtImageThumbnailUrl: String? = "",

    @Json(name = "song_art_image_url")
    var songArtImageUrl: String? = "",

    @Json(name = "stats")
    var stats: StatsDto? = null,

    @Json(name = "title")
    var title: String? = "",

    @Json(name = "title_with_featured")
    var titleWithFeatured: String? = "",

    @Json(name = "url")
    var url: String? = "",

    @Json(name = "album")
    var album: AlbumDto? = null,

    @Json(name = "primary_artist")
    var primaryArtist: PrimaryArtistDto? = null,
) : Parcelable

