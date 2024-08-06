package com.example.imran_mamirov_hw_youtubeapi.ui.fragments.playlists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imran_mamirov_hw_youtubeapi.Utils.Resource
import com.example.imran_mamirov_hw_youtubeapi.data.network.model.BaseResponse
import com.example.imran_mamirov_hw_youtubeapi.data.repository.Repository
import kotlinx.coroutines.launch

class PlaylistViewModel(private val repository: Repository) : ViewModel() {

    private val _playlists = MutableLiveData<Resource<BaseResponse>>()
    val playlists: LiveData<Resource<BaseResponse>> get() = _playlists

    init {
        fetchPlaylists()
    }

    fun fetchPlaylists() {
        viewModelScope.launch {
            repository.getPlaylists().observeForever{
                _playlists.postValue(it)
            }
        }
    }
}