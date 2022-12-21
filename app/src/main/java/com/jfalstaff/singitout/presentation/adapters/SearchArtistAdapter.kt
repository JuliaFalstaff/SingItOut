package com.jfalstaff.singitout.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jfalstaff.singitout.data.network.dto.searchDto.Hit
import com.jfalstaff.singitout.databinding.ItemMainArtistBinding
import com.jfalstaff.singitout.databinding.ItemMainBinding

class SearchArtistAdapter: ListAdapter<Hit, SearchArtistAdapter.SearchViewHolder>(DiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(ItemMainArtistBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class SearchViewHolder(val binding: ItemMainArtistBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(search: Hit) {
            binding.artistNameTextTitle.text = search.result.primaryArtist.name
            Glide.with(itemView)
                .load(search.result.primaryArtist.imageUrl)
                .circleCrop()
                .into(binding.imageArtist)
        }
    }
}