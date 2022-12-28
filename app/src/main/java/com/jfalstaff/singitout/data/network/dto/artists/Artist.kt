package com.jfalstaff.singitout.data.network.dto.artists

import com.google.gson.annotations.SerializedName

data class Artist(
    @SerializedName("alternate_names")
    val alternateNames: List<Any>? = null,
    @SerializedName("api_path")
    val apiPath: String,
    @SerializedName("description")
    val description: Description,
    @SerializedName("facebook_name")
    val facebookName: String,
    @SerializedName("followers_count")
    val followersCount: Int,
    @SerializedName("header_image_url")
    val headerImageUrl: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("instagram_name")
    val instagramName: String,
    @SerializedName("is_meme_verified")
    val isMemeVerified: Boolean,
    @SerializedName("is_verified")
    val isVerified: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("translation_artist")
    val translationArtist: Boolean,
    @SerializedName("twitter_name")
    val twitterName: String,
    @SerializedName("url")
    val url: String
)
