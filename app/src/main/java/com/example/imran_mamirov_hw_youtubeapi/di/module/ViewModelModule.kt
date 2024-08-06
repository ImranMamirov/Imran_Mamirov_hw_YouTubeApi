package com.example.imran_mamirov_hw_youtubeapi.di.module

import com.example.imran_mamirov_hw_youtubeapi.ui.fragments.playlists.PlaylistViewModel
import com.example.imran_mamirov_hw_youtubeapi.ui.fragments.playlistsdetail.PlaylistDetailAdapter
import com.example.imran_mamirov_hw_youtubeapi.ui.fragments.playlistsdetail.PlaylistDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {
    viewModel {
        PlaylistViewModel(get())
    }

    viewModel {
        PlaylistDetailViewModel(get())
    }
}