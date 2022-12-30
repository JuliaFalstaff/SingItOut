package com.jfalstaff.singitout.data.network.dto.albums

import com.google.gson.annotations.SerializedName
import com.jfalstaff.singitout.data.network.dto.albums.Response
import com.jfalstaff.singitout.data.network.dto.searchDto.Meta

data class ResponseAlbums(
    val meta: Meta,
    @SerializedName("response")
    val response: Response?
)
