package com.jfalstaff.singitout.data.network.dto.searchDto

import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("status")
    val status: Int
)