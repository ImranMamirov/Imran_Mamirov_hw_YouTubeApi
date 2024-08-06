package com.example.imran_mamirov_hw_youtubeapi.ui.fragments.playlists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.imran_mamirov_hw_youtubeapi.databinding.ItemPlaylistsBinding
import com.example.imran_mamirov_hw_youtubeapi.data.network.model.Item

class PlayListsAdapter(private val onItemClick: (Item) -> Unit) :
    ListAdapter<Item, PlayListsAdapter.ViewHolder>(diffUtil) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPlaylistsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemPlaylistsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Item) = with(binding) {
            tvQuantityVideo.text = item.snippet.title
            tvNamePlaylist.text = item.snippet.title
            imgPlaylists.load(item.snippet.thumbnails.medium.url) {
                crossfade(true)
            }
            root.setOnClickListener {
                onItemClick(item)
            }
        }
    }
}

private val diffUtil = object : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Item, newItem: Item) = oldItem == newItem
}