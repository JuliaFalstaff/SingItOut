package com.jfalstaff.singitout.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jfalstaff.singitout.data.network.dto.searchDto.Hit
import com.jfalstaff.singitout.databinding.ItemMainBinding

class SearchAdapter: ListAdapter<Hit, SearchAdapter.SearchViewHolder>(DiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class SearchViewHolder(val binding: ItemMainBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(search: Hit) {
            binding.artistNameTextTitle.text = search.result.artistNames
            binding.lyricsTitleTextTitle.text = search.result.title
            Glide.with(itemView)
                .load(search.result.headerImageUrl)
                .into(binding.posterTitle)

        }

    }


}