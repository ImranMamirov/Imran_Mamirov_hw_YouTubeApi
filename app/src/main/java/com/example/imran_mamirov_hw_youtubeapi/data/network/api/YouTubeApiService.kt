package com.example.imran_mamirov_hw_youtubeapi.data.network.api

import com.example.imran_mamirov_hw_youtubeapi.data.network.model.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApiService {
        @GET(/* value = */ "playlists")
        suspend fun getPlaylists(
            @Query("part") part: String,
            @Query("channelId") channelId: String,
            @Query("key") apiKey: String,
            @Query("maxResults") maxResults: Int
        ): BaseResponse

        @GET("playlistItems")
        suspend fun getPlaylistItems(
            @Query("part") part: String,
            @Query("playlistId") playlistId: String,
            @Query("key") apiKey: String,
            @Query("maxResults") maxResults: Int
        ): BaseResponse
}