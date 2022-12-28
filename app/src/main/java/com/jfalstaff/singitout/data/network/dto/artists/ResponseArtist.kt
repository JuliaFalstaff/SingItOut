package com.jfalstaff.singitout.data.network.dto.artists

import com.jfalstaff.singitout.data.network.dto.searchDto.Meta

data class ResponseArtist(
    val meta: Meta,
    val artist: Artist
)
