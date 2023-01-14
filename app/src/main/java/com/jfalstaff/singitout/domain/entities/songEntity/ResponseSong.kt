package com.jfalstaff.singitout.domain.entities.songEntity

import com.jfalstaff.singitout.domain.entities.searchEntity.Meta

data class ResponseSong(
    val meta: Meta,
    val response: Response,
)
