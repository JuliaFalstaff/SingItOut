package com.jfalstaff.singitout.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jfalstaff.singitout.data.network.dto.searchDto.Hit
import com.jfalstaff.singitout.data.network.dto.searchDto.PrimaryArtist
import com.jfalstaff.singitout.databinding.ItemMainArtistBinding
import com.jfalstaff.singitout.databinding.ItemMainBinding

class SearchArtistAdapter: PagingDataAdapter<PrimaryArtist, SearchArtistAdapter.SearchViewHolder>(DiffUtilArtist()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(ItemMainArtistBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class SearchViewHolder(val binding: ItemMainArtistBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(artist: PrimaryArtist?) {
            binding.artistNameTextTitle.text = artist?.name
            Glide.with(itemView)
                .load(artist?.imageUrl)
                .circleCrop()
                .into(binding.imageArtist)
        }
    }
}