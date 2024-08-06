package com.example.imran_mamirov_hw_youtubeapi.data.network.model


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("kind")
    val kind: String,
    @SerializedName("tage")
    val tage: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("snippet")
    val snippet: Snippet,
    @SerializedName("contentDetails")
    val contentDetails: ContentDetails
)