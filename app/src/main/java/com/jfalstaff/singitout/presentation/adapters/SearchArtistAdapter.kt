package com.jfalstaff.singitout.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jfalstaff.singitout.R
import com.jfalstaff.singitout.data.network.dto.searchDto.PrimaryArtist
import com.jfalstaff.singitout.databinding.ItemMainArtistBinding

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
            Glide.with(itemView)
                .load(artist?.imageUrl)
                .circleCrop()
                .placeholder(R.drawable.progress_animation)
                .into(binding.imageArtist)
            itemView.setOnClickListener {
                onItemArtistClickListener?.invoke(artist)
            }
        }
    }
}