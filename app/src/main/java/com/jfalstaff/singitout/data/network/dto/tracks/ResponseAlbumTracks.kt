package com.jfalstaff.singitout.data.network.dto.tracks

import com.jfalstaff.singitout.data.network.dto.searchDto.Meta

data class ResponseAlbumTracks(
    val meta: Meta,
    val response: Response,
)
