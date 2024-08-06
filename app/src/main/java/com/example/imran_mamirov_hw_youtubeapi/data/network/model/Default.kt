package com.example.imran_mamirov_hw_youtubeapi.data.network.model


import com.google.gson.annotations.SerializedName

data class Default(
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int,
    @SerializedName("height")
    val height: Int
)