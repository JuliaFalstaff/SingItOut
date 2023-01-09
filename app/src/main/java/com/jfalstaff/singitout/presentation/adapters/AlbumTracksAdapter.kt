package com.jfalstaff.singitout.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jfalstaff.singitout.data.network.dto.tracks.Track
import com.jfalstaff.singitout.databinding.ItemAlbumTrackBinding

class AlbumTracksAdapter :
    ListAdapter<Track, AlbumTracksAdapter.TracksViewHolder>(BaseItemDiffCallback<Track>()) {
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
        }
    }
}