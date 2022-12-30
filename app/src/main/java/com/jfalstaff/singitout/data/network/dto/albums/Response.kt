package com.jfalstaff.singitout.data.network.dto.albums

import com.google.gson.annotations.SerializedName
import com.jfalstaff.singitout.data.network.dto.albums.Albums
import com.jfalstaff.singitout.presentation.adapters.AlbumsAdapter


data class Response(
  @SerializedName("albums")
  val albums: List<Albums>? = listOf(Albums(id = 1, name = "dhsjdhuwuw 1"), Albums(id = 2, name = "skjdkdjs 2")),
  @SerializedName("next_page")
  val nextPage: String? = ""
)