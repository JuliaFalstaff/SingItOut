package com.jfalstaff.singitout.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jfalstaff.singitout.databinding.ItemMainSearchResultBinding
import com.jfalstaff.singitout.domain.entities.searchEntity.Hit
import com.jfalstaff.singitout.presentation.core.BaseItemDiffCallback
import com.jfalstaff.singitout.presentation.glide.GlideFactory

class SearchAdapter : PagingDataAdapter<Hit, SearchAdapter.SearchViewHolder>(
    BaseItemDiffCallback<Hit>()
) {

    var onItemHitClickListener: ((Hit?) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            ItemMainSearchResultBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class SearchViewHolder(private val binding: ItemMainSearchResultBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(search: Hit?) {
            binding.artistNameTextTitle.text = search?.result?.artistNames
            binding.lyricsTitleTextTitle.text = search?.result?.title
            GlideFactory.load(
                viewContainer = itemView,
                url = search?.result?.headerImageUrl,
                imageView = binding.posterTitle
            )
            itemView.setOnClickListener {
                onItemHitClickListener?.invoke(search)
            }
        }
    }
}