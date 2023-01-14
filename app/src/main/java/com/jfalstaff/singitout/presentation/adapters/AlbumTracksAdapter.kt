package com.jfalstaff.singitout.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jfalstaff.singitout.databinding.ItemAlbumTrackBinding
import com.jfalstaff.singitout.domain.entities.tracksEntity.Track
import com.jfalstaff.singitout.presentation.core.BaseItemDiffCallback

class AlbumTracksAdapter :
    ListAdapter<Track, AlbumTracksAdapter.TracksViewHolder>(BaseItemDiffCallback<Track>()) {

    var onTrackItemClickListener: ((Track) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AlbumTracksAdapter.TracksViewHolder {
        return TracksViewHolder(
            ItemAlbumTrackBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AlbumTracksAdapter.TracksViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class TracksViewHolder(private val binding: ItemAlbumTrackBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(track: Track) {
            binding.numberOfTrackInAlbum.text = track.number.toString()
            binding.titleOfSongTextView.text = track.song?.title
            itemView.setOnClickListener {
                onTrackItemClickListener?.invoke(track)
            }
        }
    }
}