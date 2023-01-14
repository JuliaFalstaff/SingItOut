package com.jfalstaff.singitout.data.network.dto.song

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.jfalstaff.singitout.data.network.dto.searchDto.PrimaryArtistDto
import com.jfalstaff.singitout.data.network.dto.searchDto.StatsDto
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class SongDto(
    @Json(name = "annotation_count")
    @Expose
    var annotationCount: Int? = 0,

    @Json(name = "api_path")
    @Expose
    var apiPath: String? = "",

    @Json(name = "apple_music_id")
    @Expose
    var appleMusicId: String? = "",

    @Json(name = "apple_music_player_url")
    @Expose
    var appleMusicPlayerUrl: String? = "",

    @Json(name = "artist_names")
    @Expose
    var artistNames: String? = "",

    @Json(name = "embed_content")
    @Expose
    var embedContent: String? = "",

    @Json(name = "featured_video")
    @Expose
    var featuredVideo: Boolean? = false,

    @Json(name = "full_title")
    @Expose
    var fullTitle: String? = "",

    @Json(name = "header_image_thumbnail_url")
    @Expose
    var headerImageThumbnailUrl: String? = "",

    @Json(name = "header_image_url")
    @Expose
    var headerImageUrl: String? = "",

    @Json(name = "id")
    @Expose
    var id: Int? = 0,

    @Json(name = "language")
    @Expose
    var language: String? = "",

    @Json(name = "lyrics_owner_id")
    @Expose
    var lyricsOwnerId: Int? = 0,
//
//    @Json(name="lyrics_placeholder_reason")
//    @Expose
//    var lyricsPlaceholderReason: Any? = "",

    @Json(name = "lyrics_state")
    @Expose
    var lyricsState: String? = "",

    @Json(name = "path")
    @Expose
    var path: String? = "",

//    @Json(name="pyongs_count")
//    @Expose
//    var pyongsCount: Any? = ",
//
//    @Json(name="recording_location")
//    @Expose
//    var recordingLocation: Any? = ",

    @Json(name = "relationships_index_url")
    @Expose
    var relationshipsIndexUrl: String? = "",

    @Json(name = "release_date")
    @Expose
    var releaseDate: String? = "",

    @Json(name = "release_date_for_display")
    @Expose
    var releaseDateForDisplay: String? = "",

    @Json(name = "release_date_with_abbreviated_month_for_display")
    @Expose
    var releaseDateWithAbbreviatedMonthForDisplay: String? = "",

    @Json(name = "song_art_image_thumbnail_url")
    @Expose
    var songArtImageThumbnailUrl: String? = "",

    @Json(name = "song_art_image_url")
    @Expose
    var songArtImageUrl: String? = "",

    @Json(name = "stats")
    @Expose
    var stats: StatsDto? = null,

    @Json(name = "title")
    @Expose
    var title: String? = "",

    @Json(name = "title_with_featured")
    @Expose
    var titleWithFeatured: String? = "",

    @Json(name = "url")
    @Expose
    var url: String? = "",

//    @Json(name="current_user_metadata")
//    @Expose
//    var currentUserMetadata: CurrentUserMetadata? = null,
//
    @Json(name = "album")
    @Expose
    var album: AlbumDto? = null,
//
//    @Json(name="custom_performances")
//    @Expose
//    var customPerformances: List<CustomPerformance>? = null,
//
//    @Json(name="description_annotation")
//    @Expose
//    var descriptionAnnotation: DescriptionAnnotation? = null,
//
//    @Json(name="featured_artists")
//    @Expose
//    var featuredArtists: List<Any>? = null,
//
//    @Json(name="lyrics_marked_complete_by")
//    @Expose
//    var lyricsMarkedCompleteBy: Any? = null,
//
//    @Json(name="lyrics_marked_staff_approved_by")
//    @Expose
//    var lyricsMarkedStaffApprovedBy: Any? = null,

//    @Json(name="media")
//    @Expose
//    var media: List<Medium__1>? = null,

    @Json(name = "primary_artist")
    @Expose
    var primaryArtist: PrimaryArtistDto? = null,

//    @Json(name="producer_artists")
//    @Expose
//    var producerArtists: List<ProducerArtist>? = null,
//
//    @Json(name="song_relationships")
//    @Expose
//    var songRelationships: List<SongRelationship>? = null,

//    @Json(name="translation_songs")
//    @Expose
//    var translationSongs: List<Any>? = null,
//
//    @Json(name="verified_annotations_by")
//    @Expose
//    var verifiedAnnotationsBy: List<Any>? = null,
//
//    @Json(name="verified_contributors")
//    @Expose
//    var verifiedContributors: List<Any>? = null,
//
//    @Json(name="verified_lyrics_by")
//    @Expose
//    var verifiedLyricsBy: List<Any>? = null,
//
//    @Json(name="writer_artists")
//    @Expose
//    var writerArtists: List<WriterArtist>? = null,
) : Parcelable

