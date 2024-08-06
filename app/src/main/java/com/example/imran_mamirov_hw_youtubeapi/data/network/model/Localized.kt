package com.example.imran_mamirov_hw_youtubeapi.data.network.model


import com.google.gson.annotations.SerializedName

data class Localized(
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String
)