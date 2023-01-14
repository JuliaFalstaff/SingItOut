package com.jfalstaff.singitout.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.jfalstaff.singitout.R
import com.jfalstaff.singitout.databinding.FragmentAlbumTracksBinding
import com.jfalstaff.singitout.domain.entities.albumsEntity.Albums
import com.jfalstaff.singitout.presentation.adapters.AlbumTracksAdapter
import com.jfalstaff.singitout.presentation.core.BaseFragment
import com.jfalstaff.singitout.presentation.glide.GlideFactory
import com.jfalstaff.singitout.presentation.viewmodels.AlbumTrackViewModel

class AlbumTracksFragment :
    BaseFragment<FragmentAlbumTracksBinding>(FragmentAlbumTracksBinding::inflate) {
    private var adapter: AlbumTracksAdapter? = null
    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[AlbumTrackViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val album = arguments?.getParcelable(ALBUM_KEY) ?: Albums()
        initAdapter()
        initViewModel(album)
        renderAlbumInfo(album)
    }

    private fun renderAlbumInfo(album: Albums) {
        binding.albumTitleTextView.text = album.fullTitle
        binding.releaseAlbumDateTextView.text = album.releaseDateComponents?.year.toString()
        GlideFactory.load(requireView(), album.coverArtUrl, binding.albumCoverImageView)
    }

    private fun initViewModel(album: Albums) {
        viewModel.loadAlbumTracks(album.id)
        viewModel.tracks.observe(viewLifecycleOwner) {
            adapter?.submitList(it)
        }
    }

    private fun initAdapter() {
        adapter = AlbumTracksAdapter()
        binding.recyclerViewAlbumTracks.adapter = adapter
        adapter?.onTrackItemClickListener = {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, SongLyricsFragment.newInstance(it.song?.id ?: 0))
                .addToBackStack(null)
                .commit()
        }
    }

    companion object {
        private const val ALBUM_KEY = "album"
        fun newInstance(album: Albums) = AlbumTracksFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ALBUM_KEY, album)
            }
        }
    }
}