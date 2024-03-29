package com.jfalstaff.singitout.presentation.core

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class BaseItemDiffCallback<T: Any>: DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem.toString() == newItem.toString()

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem == newItem
}