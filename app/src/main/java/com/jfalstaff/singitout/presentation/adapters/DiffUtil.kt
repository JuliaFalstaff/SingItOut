package com.jfalstaff.singitout.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.jfalstaff.singitout.data.network.dto.searchDto.Hit
import com.jfalstaff.singitout.data.network.dto.searchDto.Response
import com.jfalstaff.singitout.data.network.dto.searchDto.ResponseServer

class DiffUtil: DiffUtil.ItemCallback<Hit>() {
    override fun areItemsTheSame(oldItem: Hit, newItem: Hit) = oldItem == newItem

    override fun areContentsTheSame(oldItem: Hit, newItem: Hit) = oldItem == newItem
}