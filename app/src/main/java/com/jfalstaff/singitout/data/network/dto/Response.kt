package com.jfalstaff.singitout.data.network.dto

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("hits")
    val hits: List<Hit>? = null
)
