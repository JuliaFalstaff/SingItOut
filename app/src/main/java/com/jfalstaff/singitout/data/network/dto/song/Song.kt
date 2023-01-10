package com.jfalstaff.singitout.data.network.dto.song

import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

import com.jfalstaff.singitout.data.network.dto.searchDto.PrimaryArtist

import com.jfalstaff.singitout.data.network.dto.searchDto.Stats
import kotlinx.parcelize.Parcelize

@Parcelize
data class Song (
    @SerializedName("annotation_count")
    @Expose
    var annotationCount: Int? = 0,

    @SerializedName("api_path")
    @Expose
    var apiPath: String? = "",

    @SerializedName("apple_music_id")
    @Expose
    var appleMusicId: String? = "",

    @SerializedName("apple_music_player_url")
    @Expose
    var appleMusicPlayerUrl: String? = "",

    @SerializedName("artist_names")
    @Expose
    var artistNames: String? = "",

    @SerializedName("embed_content")
    @Expose
    var embedContent: String? = "",

    @SerializedName("featured_video")
    @Expose
    var featuredVideo: Boolean? = false,

    @SerializedName("full_title")
    @Expose
    var fullTitle: String? = "",

    @SerializedName("header_image_thumbnail_url")
    @Expose
    var headerImageThumbnailUrl: String? = "",

    @SerializedName("header_image_url")
    @Expose
    var headerImageUrl: String? = "",

    @SerializedName("id")
    @Expose
    var id: Int? = 0,

    @SerializedName("language")
    @Expose
    var language: String? = "",

    @SerializedName("lyrics_owner_id")
    @Expose
    var lyricsOwnerId: Int? = 0,
//
//    @SerializedName("lyrics_placeholder_reason")
//    @Expose
//    var lyricsPlaceholderReason: Any? = "",

    @SerializedName("lyrics_state")
    @Expose
    var lyricsState: String? = "",

    @SerializedName("path")
    @Expose
    var path: String? = "",

//    @SerializedName("pyongs_count")
//    @Expose
//    var pyongsCount: Any? = ",
//
//    @SerializedName("recording_location")
//    @Expose
//    var recordingLocation: Any? = ",

    @SerializedName("relationships_index_url")
    @Expose
    var relationshipsIndexUrl: String? = "",

    @SerializedName("release_date")
    @Expose
    var releaseDate: String? = "",

    @SerializedName("release_date_for_display")
    @Expose
    var releaseDateForDisplay: String? = "",

    @SerializedName("release_date_with_abbreviated_month_for_display")
    @Expose
    var releaseDateWithAbbreviatedMonthForDisplay: String? = "",

    @SerializedName("song_art_image_thumbnail_url")
    @Expose
    var songArtImageThumbnailUrl: String? = "",

    @SerializedName("song_art_image_url")
    @Expose
    var songArtImageUrl: String? = "",

    @SerializedName("stats")
    @Expose
    var stats: Stats? = null,

    @SerializedName("title")
    @Expose
    var title: String? = "",

    @SerializedName("title_with_featured")
    @Expose
    var titleWithFeatured: String? = "",

    @SerializedName("url")
    @Expose
    var url: String? = "",

//    @SerializedName("current_user_metadata")
//    @Expose
//    var currentUserMetadata: CurrentUserMetadata? = null,
//
    @SerializedName("album")
    @Expose
    var album: Album? = null,
//
//    @SerializedName("custom_performances")
//    @Expose
//    var customPerformances: List<CustomPerformance>? = null,
//
//    @SerializedName("description_annotation")
//    @Expose
//    var descriptionAnnotation: DescriptionAnnotation? = null,
//
//    @SerializedName("featured_artists")
//    @Expose
//    var featuredArtists: List<Any>? = null,
//
//    @SerializedName("lyrics_marked_complete_by")
//    @Expose
//    var lyricsMarkedCompleteBy: Any? = null,
//
//    @SerializedName("lyrics_marked_staff_approved_by")
//    @Expose
//    var lyricsMarkedStaffApprovedBy: Any? = null,

//    @SerializedName("media")
//    @Expose
//    var media: List<Medium__1>? = null,

    @SerializedName("primary_artist")
    @Expose
    var primaryArtist: PrimaryArtist? = null,

//    @SerializedName("producer_artists")
//    @Expose
//    var producerArtists: List<ProducerArtist>? = null,
//
//    @SerializedName("song_relationships")
//    @Expose
//    var songRelationships: List<SongRelationship>? = null,

//    @SerializedName("translation_songs")
//    @Expose
//    var translationSongs: List<Any>? = null,
//
//    @SerializedName("verified_annotations_by")
//    @Expose
//    var verifiedAnnotationsBy: List<Any>? = null,
//
//    @SerializedName("verified_contributors")
//    @Expose
//    var verifiedContributors: List<Any>? = null,
//
//    @SerializedName("verified_lyrics_by")
//    @Expose
//    var verifiedLyricsBy: List<Any>? = null,
//
//    @SerializedName("writer_artists")
//    @Expose
//    var writerArtists: List<WriterArtist>? = null,
): Parcelable

