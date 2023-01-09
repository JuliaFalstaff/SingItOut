package com.jfalstaff.singitout.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jfalstaff.singitout.R
import com.jfalstaff.singitout.data.network.dto.albums.Albums
import com.jfalstaff.singitout.data.network.dto.albums.ArtistAlbum
import com.jfalstaff.singitout.databinding.ItemAlbumBinding

class AlbumsAdapter :
    ListAdapter<Albums, AlbumsAdapter.AlbumViewHolder>(BaseItemDiffCallback<Albums>()) {

    var onAlbumItemClickListener: ((Albums) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AlbumViewHolder {
        return AlbumViewHolder(
            ItemAlbumBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class AlbumViewHolder(private val binding: ItemAlbumBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(album: Albums) {
            binding.albumTitleTextView.text = album.fullTitle
            binding.albumYearTextView.text = album.releaseDateComponents?.year.toString()
            Glide.with(itemView)
                .load(album.coverArtUrl)
                .placeholder(R.drawable.progress_animation)
                .into(binding.albumCoverImageView)
            itemView.setOnClickListener {
                onAlbumItemClickListener?.invoke(album)
            }
        }
    }
}