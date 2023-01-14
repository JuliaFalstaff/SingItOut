package com.jfalstaff.singitout.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.jfalstaff.singitout.databinding.FragmentLyricBinding
import com.jfalstaff.singitout.domain.entities.songEntity.Song
import com.jfalstaff.singitout.presentation.core.BaseFragment
import com.jfalstaff.singitout.presentation.glide.GlideFactory
import com.jfalstaff.singitout.presentation.viewmodels.SongLyricsViewModel

class SongLyricsFragment : BaseFragment<FragmentLyricBinding>(FragmentLyricBinding::inflate) {

    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[SongLyricsViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val songId = arguments?.getInt(KEY_ID_SONG) ?: 0
        initViewModel(songId)
    }

    private fun renderSongInfo(song: Song) {
        GlideFactory.load(
            requireView(),
            song.album?.coverArtUrl,
            binding.albumCoverForLyricsImageView
        )
        binding.songTitleTextView.text = song.title
        binding.artistNameTextView.text = song.primaryArtist?.name
        binding.albumTitleTextView.text = song.album?.name
        binding.releaseDateTextView.text = song.releaseDate
        GlideFactory.loadPaletteColorBackground(
            requireView(),
            song.album?.coverArtUrl,
            binding.backgroundColorImageView
        )
    }

    private fun initViewModel(id: Int) {
        viewModel.loadSongLyrics(id)
        viewModel.loadSongInfo(id)
        viewModel.lyrics.observe(viewLifecycleOwner) {
            binding.lyricTextView.text = it.lyrics?.body?.plain
        }
        viewModel.songInfo.observe(viewLifecycleOwner) {
            renderSongInfo(it)
        }
    }

    companion object {
        private const val KEY_ID_SONG = "id_song"
        fun newInstance(id: Int) = SongLyricsFragment().apply {
            arguments = Bundle().apply {
                putInt(KEY_ID_SONG, id)
            }
        }
    }
}