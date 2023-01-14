package com.jfalstaff.singitout.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jfalstaff.singitout.databinding.ItemAlbumBinding
import com.jfalstaff.singitout.domain.entities.albumsEntity.Albums
import com.jfalstaff.singitout.presentation.core.BaseItemDiffCallback
import com.jfalstaff.singitout.presentation.glide.GlideFactory

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
            GlideFactory.load(
                viewContainer = itemView,
                url = album.coverArtUrl,
                imageView = binding.albumCoverImageView
            )
            itemView.setOnClickListener {
                onAlbumItemClickListener?.invoke(album)
            }
        }
    }
}