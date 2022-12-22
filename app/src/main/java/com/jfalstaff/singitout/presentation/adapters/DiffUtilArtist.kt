package com.jfalstaff.singitout.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.jfalstaff.singitout.data.network.dto.searchDto.Hit
import com.jfalstaff.singitout.data.network.dto.searchDto.PrimaryArtist
import com.jfalstaff.singitout.data.network.dto.searchDto.Response
import com.jfalstaff.singitout.data.network.dto.searchDto.ResponseServer

class DiffUtilArtist: DiffUtil.ItemCallback<PrimaryArtist>() {
    override fun areItemsTheSame(oldItem: PrimaryArtist, newItem: PrimaryArtist) = oldItem == newItem

    override fun areContentsTheSame(oldItem: PrimaryArtist, newItem: PrimaryArtist) = oldItem == newItem
}