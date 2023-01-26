package com.jfalstaff.singitout.domain.entities.artistEntity


data class Artist(
    val apiPath: String,
    val description: Description,
    val facebookName: String? = "no data",
    val followersCount: Int? = 0,
    val headerImageUrl: String? = "",
    val id: Int? = 0,
    val imageUrl: String? = "",
    val instagramName: String? = "no data",
    val name: String? = "",
    val twitterName: String? = "no data",
    val url: String? = ""
)
