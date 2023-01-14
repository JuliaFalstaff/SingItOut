package com.jfalstaff.singitout.domain.entities.lyricsEntity


data class Lyrics(
    var type: String? = "",
    var apiPath: String? = "",
    var lyrics: LyricsText? = null,
    var path: String? = "",
    var songId: Int? = 0,
)

