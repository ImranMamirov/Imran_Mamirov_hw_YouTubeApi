package com.example.imran_mamirov_hw_youtubeapi.data.network.model


import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("kind")
    val kind: String,
    @SerializedName("tage")
    val tage: String,
    @SerializedName("pageInfo")
    val pageInfo: PageInfo,
    @SerializedName("items")
    val items: List<Item>
)