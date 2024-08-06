package com.example.imran_mamirov_hw_youtubeapi.ui.fragments.playlistsdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imran_mamirov_hw_youtubeapi.Utils.Resource
import com.example.imran_mamirov_hw_youtubeapi.data.network.model.BaseResponse
import com.example.imran_mamirov_hw_youtubeapi.data.repository.Repository
import kotlinx.coroutines.launch

class PlaylistDetailViewModel(private val repository: Repository) : ViewModel() {

    private val _playlistVideo = MutableLiveData<Resource<BaseResponse>>()
    val playlistVideo: LiveData<Resource<BaseResponse>> get() = _playlistVideo

    fun getPlaylistDetail(playlistId: String) {
        viewModelScope.launch {
            repository.getPlaylistItems(playlistId).observeForever {
                _playlistVideo.postValue(it)
            }
        }
    }
}