package com.jfalstaff.singitout.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.jfalstaff.singitout.R
import com.jfalstaff.singitout.data.network.dto.albums.Albums
import com.jfalstaff.singitout.data.network.dto.tracks.Track
import com.jfalstaff.singitout.databinding.FragmentLyricBinding

class SongLyricsFragment : Fragment() {

    private var _binding: FragmentLyricBinding? = null
    private val binding get() = _binding!!
    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[SongLyricsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLyricBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val song = arguments?.getParcelable(KEY_SONG) ?: Track()
        val album = arguments?.getParcelable(KEY_ALBUM_SONG) ?: Albums()
        initViewModel(song.song?.id ?: 0)
        renderSongInfo(album, song)
    }

    private fun renderSongInfo(album: Albums, song: Track) {
        Glide.with(requireActivity())
            .load(album.coverArtUrl)
            .placeholder(R.drawable.progress_animation)
            .into(binding.albumCoverForLyricsImageView)
        binding.songTitleTextView.text = song.song?.title
        binding.artistNameTextView.text = song.song?.primaryArtist?.name
    }

    private fun initViewModel(id: Int) {
        viewModel.loadSongLyrics(id)
        viewModel.lyrics.observe(viewLifecycleOwner) {
            binding.lyricTextView.text = it.lyrics?.body?.plain ?: "no data lyrics. Empty?"
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    companion object {
        private const val KEY_SONG = "song_data"
        private const val KEY_ALBUM_SONG = "album_song_data"
        fun newInstance(track: Track, album: Albums)= SongLyricsFragment().apply {
            arguments = Bundle().apply {
                putParcelable(KEY_SONG, track)
                putParcelable(KEY_ALBUM_SONG, album)
            }
        }
    }
}