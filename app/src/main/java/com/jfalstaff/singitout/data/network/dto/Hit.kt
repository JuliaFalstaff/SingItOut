package com.jfalstaff.singitout.data.network.dto

import com.google.gson.annotations.SerializedName

data class Hit(
    @SerializedName("type")
    val type: String,
    @SerializedName("result")
    val result: Result
)
