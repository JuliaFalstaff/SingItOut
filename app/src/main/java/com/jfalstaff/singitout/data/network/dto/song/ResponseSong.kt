package com.jfalstaff.singitout.data.network.dto.song

import com.jfalstaff.singitout.data.network.dto.searchDto.Meta

data class ResponseSong(
    val meta: Meta,
    val response: Response,
)
