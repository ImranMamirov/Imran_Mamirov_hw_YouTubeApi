package com.example.imran_mamirov_hw_youtubeapi.ui.fragments.playlists

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imran_mamirov_hw_youtubeapi.R
import com.example.imran_mamirov_hw_youtubeapi.data.network.model.Item
import com.example.imran_mamirov_hw_youtubeapi.databinding.FragmentPlaylistBinding
import com.example.imran_mamirov_hw_youtubeapi.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlaylistFragment : BaseFragment<FragmentPlaylistBinding>(
    FragmentPlaylistBinding::inflate
) {
    private val viewModel by viewModel<PlaylistViewModel>()
    private val adapter: PlayListsAdapter by lazy {
        PlayListsAdapter { video ->
            navigateToPlaylistFragment(video.id)
        }
    }

    override fun initViews() = with(binding) {
        super.initViews()
        rvPlaylist.layoutManager = LinearLayoutManager(context)
        rvPlaylist.adapter = adapter
    }

    override fun setupObservers() {
        viewModel.playlists.handleResource(
            onSuccess = { data ->
                if (data != null) {
                    adapter.submitList(data.items)
                }
            },
            isLoading = { visibility ->
                binding.progress.isVisible = visibility
            }
        )
    }

    private fun navigateToPlaylistFragment(videoId: String) {
        super.navigateToPlaylistFragment()
        val bundle = Bundle().apply {
            putString("ID", videoId)
        }
        findNavController().navigate(
            R.id.action_playlistFragment_to_playlistsDetailFragment,
            bundle
        )
    }
}