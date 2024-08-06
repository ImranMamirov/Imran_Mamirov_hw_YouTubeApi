package com.example.imran_mamirov_hw_youtubeapi.data.repository

import com.example.imran_mamirov_hw_youtubeapi.Utils.Constants
import com.example.imran_mamirov_hw_youtubeapi.data.base.BaseRepository
import com.example.imran_mamirov_hw_youtubeapi.data.network.api.YouTubeApiService
import com.example.imran_mamirov_hw_youtubeapi.data.network.model.BaseResponse

class Repository(private val apiService: YouTubeApiService) : BaseRepository() {

    fun getPlaylists() = doRequest {
        apiService.getPlaylists(
            part = Constants.PART,
            channelId = Constants.CHANNEL_ID,
            apiKey = Constants.API_KEY,
            maxResults = Constants.MAX_RESULTS
        )
    }

    fun getPlaylistItems(playlistId: String) = doRequest {
        apiService.getPlaylistItems(
            part = Constants.PART,
            playlistId = playlistId,
            apiKey = Constants.API_KEY,
            maxResults = Constants.MAX_RESULTS
        )
    }
}