package com.jfalstaff.singitout.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jfalstaff.singitout.data.network.dto.searchDto.PrimaryArtist
import com.jfalstaff.singitout.databinding.ItemMainArtistBinding
import com.jfalstaff.singitout.presentation.core.BaseItemDiffCallback
import com.jfalstaff.singitout.presentation.glide.GlideFactory

class SearchArtistAdapter :
    PagingDataAdapter<PrimaryArtist, SearchArtistAdapter.SearchViewHolder>(
        BaseItemDiffCallback<PrimaryArtist>()
    ) {

    var onItemArtistClickListener: ((PrimaryArtist?) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            ItemMainArtistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class SearchViewHolder(private val binding: ItemMainArtistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(artist: PrimaryArtist?) {
            binding.artistNameTextTitle.text = artist?.name
            GlideFactory.loadCircleCrop(itemView, artist?.imageUrl, binding.imageArtist)
            itemView.setOnClickListener {
                onItemArtistClickListener?.invoke(artist)
            }
        }
    }
}