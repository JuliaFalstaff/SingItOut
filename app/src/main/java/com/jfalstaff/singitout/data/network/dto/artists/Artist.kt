package com.jfalstaff.singitout.data.network.dto.artists

import com.squareup.moshi.Json

data class Artist(
    @Json(name = "alternate_names")
    val alternateNames: List<Any>? = null,
    @Json(name = "api_path")
    val apiPath: String,
    @Json(name = "description")
    val description: Description,
    @Json(name = "facebook_name")
    val facebookName: String? = "no data",
    @Json(name = "followers_count")
    val followersCount: Int? =0,
    @Json(name = "header_image_url")
    val headerImageUrl: String? = "",
    @Json(name = "id")
    val id: Int? = 0,
    @Json(name = "image_url")
    val imageUrl: String? = "",
    @Json(name = "instagram_name")
    val instagramName: String? = "no data",
    @Json(name = "is_meme_verified")
    val isMemeVerified: Boolean,
    @Json(name = "is_verified")
    val isVerified: Boolean,
    @Json(name = "name")
    val name: String? = "",
    @Json(name = "translation_artist")
    val translationArtist: Boolean,
    @Json(name = "twitter_name")
    val twitterName: String? = "no data",
    @Json(name = "url")
    val url: String? = ""
)
